package com.project.Band_Search.service;

import com.project.Band_Search.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);
    /*void updatePassword(User user, String newPassword);
    User getByResetPasswordToken(String token);
    void updateResetPasswordToken(String token, String email);
    User findUserByEmail(String email);*/
}
