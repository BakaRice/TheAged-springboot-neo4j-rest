package com.ricemarch.repository;

import com.ricemarch.Moment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MomentRepository extends PagingAndSortingRepository<Moment, Long> {

    List<Moment> findByTitle(@Param("title") String title);
}
