package com.project.Band_Search.repository;

import com.project.Band_Search.models.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostPaginationRepository extends PagingAndSortingRepository<Post, Long> {
    Post getById(Long id);
}