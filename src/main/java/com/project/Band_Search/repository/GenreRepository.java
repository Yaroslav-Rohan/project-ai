package com.project.Band_Search.repository;


import com.project.Band_Search.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenreName(String genre);
}
