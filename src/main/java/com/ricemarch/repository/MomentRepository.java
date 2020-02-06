package com.ricemarch.repository;

import com.ricemarch.Moment;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MomentRepository extends PagingAndSortingRepository<Moment, Long> {

    List<Moment> findByTitle(@Param("title") String title);

    @Query("match (:User{name:{name}})-[:FOLLOW]->(:User)-[:PUBLISH]->(m:Moment) return m")
    List<Moment> getMomentFollwFormUserName(String name);

//    @Query("match (:User{name:{name}})-[:FOLLOW]->(:User)-[:PUBLISH]->(m:Moment) return m")
//    Page<Moment> getMomentFollwFormUserName_page(String name, PageRequest request);

}
