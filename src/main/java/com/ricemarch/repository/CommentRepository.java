package com.ricemarch.repository;

import com.ricemarch.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    Comment findByConetnt(String conetnt);
}
