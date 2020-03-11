package com.ricemarch.repository;

import com.ricemarch.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    @Query("match (m:Comment{CommentUuid:{CommentUuid}}) return m")
    Comment findbyCommentUuid(@Param("CommentUuid") String uuid);

    @Query("match (c:Comment{CommentUuid:{CommentUuid}}) detach delete c")
    void deleteComment(@Param("CommentUuid") String uuid);


    @Query("match (c1:Comment)-[*0..]->(c:Comment{CommentUuid:{CommentUuid}}) detach delete c1")
    void deleteAllComment(@Param("CommentUuid") String uuid);

    @Query("match (m:Moment{MomentUuid:{MomentUuid}}),(u:User{name:{name}}) \n" +
            "create \n" +
            "(u)-[:COMMENT]->(:Comment{CommentUuid:{CommentUuid},content:{content},name:{name},toName:{toName}, time:timestamp()})-[:BE_COMMENTED]->(m)")
    void addCommentAtomToM(@Param("MomentUuid") String MomentUuid,
                           @Param("CommentUuid") String CommentUuid,
                           @Param("content") String content,
                           @Param("name") String name,
                           @Param("toName") String toName);

    @Query("match (c:Comment{CommentUuid:{toCommentUuid}}),(u:User{name:{name}}) \n" +
            "create \n" +
            "(u)-[:COMMENT]->(:Comment{CommentUuid:{CommentUuid},content:{content},name:{name},toName:{toName}, time:timestamp()})-[:COMMENT_IN_COMMENT]->(c)")
    void addCommentAtomToC(
            @Param("toCommentUuid") String toCommentUuid,
            @Param("CommentUuid") String CommentUuid,
            @Param("content") String content,
            @Param("name") String name,
            @Param("toName") String toName);


    @Query(value = "match (m:Moment{MomentUuid:{MomentUuid}})<-[:BE_COMMENTED]-(c:Comment) return c order by c.time",
            countQuery = "match (m:Moment{MomentUuid:{MomentUuid}})<-[:BE_COMMENTED]-(c:Comment) return count(c)")
    Page<Comment> getCommentByMoentUuid_page(@Param("MomentUuid") String MomentUuid, Pageable pageable);


    @Query(value = "match (:Comment{CommentUuid:{CommentUuid}})<-[*..]-(c:Comment) return c order by c.time",
            countQuery = "match (:Comment{CommentUuid:{CommentUuid}})<-[*..]-(c:Comment) return count(c)")
    Page<Comment> getReplyByCommentUuid_page(@Param("CommentUuid") String MomentUuid, Pageable pageable);

}
