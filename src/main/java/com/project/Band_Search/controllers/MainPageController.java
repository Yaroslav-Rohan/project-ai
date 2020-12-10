package com.project.Band_Search.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("main")
public class MainPageController {
    @GetMapping("/main")
    public String mm() {
        return "main";
    }
}
