package com.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterControllers {

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Maps to register.html inside templates
    }
}
