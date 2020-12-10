package com.project.Band_Search.resource;

import com.project.Band_Search.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Resource<T>{
    @GetMapping
    ResponseEntity<Page<T>> findAll(Pageable pageable);
}