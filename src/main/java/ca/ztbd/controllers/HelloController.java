package ca.ztbd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Spring Boot world!";
    }
}
