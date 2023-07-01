package com.my.gym.controller;

import com.my.gym.model.User;
import com.my.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    public HomeController() {

    }

    @GetMapping({"/", "home"})
    public String home() {
        return "/home";
    }
}
