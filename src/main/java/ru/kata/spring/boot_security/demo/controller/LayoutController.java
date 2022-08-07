package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LayoutController {

    @GetMapping("/")
    public String index() {
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String admin() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "index";
    }
}