package com.project.Band_Search.repository;
 import com.project.Band_Search.models.Post;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post getTopByPostHeaderOrderByIdDesc(String postHeader);
}
