package com.eam.Fixed.Assets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testADController {
    @GetMapping("/login")
    public String tryLogin(){
        return "Test Login using AZURE";
    }
}
