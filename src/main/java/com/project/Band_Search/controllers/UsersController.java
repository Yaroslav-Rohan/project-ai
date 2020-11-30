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
    @GetMapping("/users")
    public List<User> users(Model model) {
        return (List<User>) this.userRep.findAll();
        // model.addAttribute("usersInformation", usersInformation);
        // return "users";
    }

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
        //  User user = null;
  /*      if (//userName.length() == 0 ||
                firstName.length() == 0 ||
                        lastName.length() == 0 ||
                        //login.length() == 0 ||
                        password.length() == 0 ||
                        email.length() == 0) {
        //    model.addAttribute("check", "fill all text fields");
            nt index = email.contains("@") ? email.indexOf("@") : email.length() - 5;
            String emailSub = email.substring(index, email.length());
           if (!email.contains("@") || !emailSub.contains(".")) {
           user = new User(firstName, lastName, password, email);
             }

        //return "user-add";
       /   }
*/
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        //  return userRep.save(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDb = userRep.findByEmail(user.getEmail());
        if (userFromDb != null) {
            // return userRep.save(user);
            //return userFromDb;
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
    //    @GetMapping("/user/{id}/edit")
//    public String userIDEdit (@PathVariable(value = "id") Long id,
//                                Model model)
//    {
//        if (!userRep.existsById(id))
//            return "redirect:/users";
//        Optional<User> user = userRep.findById(id);
//        model.addAttribute("user", user.get());
//        return "user-edit";
//    }
//    @PostMapping("/user/{id}/edit")
//    public String userIDPostEdit(@PathVariable(value = "id") Long id,
//                                 @RequestParam String userName,
//                                 @RequestParam String firstName,
//                                 @RequestParam String secondName,
//                                 @RequestParam String login,
//                                 @RequestParam String password,
//                                 @RequestParam String email,
//                                 Model model) {
//
//        if (userName.length() == 0 ||
//                firstName.length() == 0 ||
//                secondName.length() == 0 ||
//                email.length() == 0){
//            model.addAttribute("check", "fill all text fields");
//            return "user-add";
//        }
//
//
//        int index = email.contains("@") ? email.indexOf("@") : email.length() - 5;
//        String emailSub = email.substring(index, email.length());
//        if (!email.contains("@") || !emailSub.contains(".")){
//            model.addAttribute("check", "invalid email");
//            return "user-add";
//        }
//
//        User user = userRep.findByEmail(email);
//
//        if (user != null) {
//            model.addAttribute("check", "user already exist");
//            return "user-add";
//        } else {
//            User user1 = userRep.findById(id).orElseThrow();
//            user1.setUserName(userName);
//            user1.setFirstName(firstName);
//            user1.setSecondName(secondName);
//            user1.setLogin(login);
//            user1.setPassword(password);
//            user1.setEmail(email);
//            userRep.save(user1);
//            model.addAttribute("check", "");
//            return "redirect:/users";
//        }
//    }
}
