package com.vivek.Spring.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentcontroller {

    List<student> students = new ArrayList<>(List.of(
            new student(1,"vivek" , 23),
            new student(2,"popy" , 55)
    ));
    @GetMapping("/students")
    public List<student> getallstudnets(){
        return students;
    }

    //generating a token
    @GetMapping("/token")
    public CsrfToken gettoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/studnets")
    public student addstudent (@RequestBody student std){
       students.add(std);
       return std;
    }

}
