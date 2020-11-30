package com.project.Band_Search.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloWorldController {

    @RequestMapping("/dashboard")
    public String firstPage() {
        return "success";
    }
}
