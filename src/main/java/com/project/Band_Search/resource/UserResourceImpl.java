package com.project.Band_Search.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.Band_Search.models.User;
import com.project.Band_Search.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")

public class UserResourceImpl implements Resource<User>{
    @Autowired
    private IService<User> userService;

    @Override
    public ResponseEntity<Page<User>> findAll(Pageable pageable){
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

}
