package com.my.gym.controller;


import com.my.gym.model.User;
import com.my.gym.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login-form")
    public String login() {
        return "login-page";
    }

    @GetMapping("/authenticate")
    public String authenticate(@AuthenticationPrincipal SecurityUser securityUser, Principal principal) {

        return "redirect:/home";
    }
}
