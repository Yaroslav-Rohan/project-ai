package com.project.Band_Search.repository;


import com.project.Band_Search.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
  //  User findByResetToken(String token);
  @Query(
          value = "SELECT * FROM user u WHERE u.reset_password_token IS NOT NULL ",
          nativeQuery = true)
    User findByResetPasswordToken(String resetToken);
}