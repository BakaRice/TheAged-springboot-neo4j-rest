package com.ricemarch.repository;

import com.ricemarch.Comment;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    @Query("match (m:Comment{CommentUuid:{CommentUuid}}) return m")
    Comment findByCommentUuid(@Param("CommentUuid") String uuid);

    @Query("match (c:Comment{CommentUuid:{CommentUuid}}) detach delete c")
    void deleteComment(@Param("CommentUuid") String uuid);


    @Query("match (c1:Comment)-[*0..]->(c:Comment{CommentUuid:{CommentUuid}}) detach delete c1")
    void deleteAllComment(@Param("CommentUuid") String uuid);
}
