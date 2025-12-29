package com.upiiz.ejercicio07.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "API funcionando ✅\nSwagger: /swagger-ui/index.html";
    }
}
