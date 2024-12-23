package com.vivek.Spring.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sec")
public class hellocontroller {

    @GetMapping("/hello")
    public String greet(){
        return "hello " ;
    }
}
