package com.ricemarch.repository;

import com.ricemarch.Moment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MomentRepository extends PagingAndSortingRepository<Moment, Long> {


    List<Moment> findByTitle(@Param("title") String title);

    @Query("match (m:Moment{MomentUuid:{MomentUuid}}) return m")
    Moment findByMomentUuid(String MomentUuid);

    @Query("match (:User{name:{name}})-[:FOLLOW]->(:User)-[:PUBLISH]->(m:Moment) return m")
    List<Moment> getMomentFollwFormUserName(String name);

    @Query(value = "match (:User{name:{name}})-[:FOLLOW]->(:User)-[:PUBLISH]->(m:Moment) return m",
            countQuery = "match (:User{name:{name}})-[:FOLLOW]->(:User)-[:PUBLISH]->(m:Moment) return count(m)")
    Page<Moment> getMomentFollwFormUserName_page(String name, Pageable pageable);


}
