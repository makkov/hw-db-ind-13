package com.example.hwdbind13.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping
    public String test() {
        return "hello";
    }
}
