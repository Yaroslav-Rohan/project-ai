package com.project.Band_Search.resource;


import com.project.Band_Search.models.Post;
import com.project.Band_Search.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postList")
@CrossOrigin(origins = "http://localhost:3000")


public class PostResourceImpl implements Resource<Post>{
    @Autowired
    private IService<Post> postService;

    @Override
    public ResponseEntity<Page<Post>> findAll(Pageable pageable){
        return new ResponseEntity<>(postService.findAll(pageable), HttpStatus.OK);
    }

}
