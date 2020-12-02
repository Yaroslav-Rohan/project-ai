package com.project.Band_Search.service;

//import com.project.Band_Search.controllers.UsersController;
import com.project.Band_Search.models.User;
import com.project.Band_Search.repository.UserRepository;
import com.project.Band_Search.resource.Resource;
import com.project.Band_Search.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements IService<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
