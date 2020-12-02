package com.project.Band_Search.controllers;


import com.project.Band_Search.models.User;
import com.project.Band_Search.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private PasswordEncoder passwordEncoder;

 /*   @PostMapping("/login")
    public User userLogin(@RequestBody User user) {
        User userFromDb = userRep.findByEmail(user.getEmail());
        if (userFromDb != null) {
            if (userFromDb.getPassword().equals(user.getPassword())) {
                return userFromDb;
            } else {
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN, "WRONG PASSWORD");
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "NOT FOUND");
    }*/

    @PostMapping("/registration")
    public User userPostAdd(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDb = userRep.findByEmail(user.getEmail());

        if (userFromDb != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "USER EXISTS");
        } else {
            if ((user.getPassword().length() < 1))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "CANT SET 0 PASSWORD");
            return userRep.save(user);
        }
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable(value = "id") Long id,
                              Model model) {
        if (!userRep.existsById(id))
            return "redirect:/users";
        Optional<User> user = userRep.findById(id);
        model.addAttribute("user", user.get());
        return "user-details";
    }
}
