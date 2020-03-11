package com.ricemarch.repository;

import com.ricemarch.entity.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("match (u:User{name:{name}}) return u")
    User findByName(@Param("name") String name);

    @Query("match (u:User{name:{name1}}),(u2:User{name:{name2}}) create (u)-[:FOLLOW]->(u2)")
    void addFollow(String name1, String name2);

    //判断两用户是否关注 通过count follow衡量
    @Query("match (u:User{name:{name1}})-[r:FOLLOW]->(u2:User{name:{name2}}) return count(r)")
    int findFollow(String name1, String name2);

    @Query("match (u:User{name:{_name1}})-[r:FOLLOW]->(u2:User{name:{_name2}}) delete r")
    void deletefollow(String _name1, String _name2);

    @Query("match (u:User{name:{name}})-[r:LIKE_IN]->(:Moment{MomentUuid:{uuid}}) return count(r)")
    int findLike(String name,String uuid);

    @Query("match (u:User{name:{name}})-[r:LIKE_IN]->(:Moment{MomentUuid:{uuid}})  delete r")
    void deletelike(String name,String uuid);


}
