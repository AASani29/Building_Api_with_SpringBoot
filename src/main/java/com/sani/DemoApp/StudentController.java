package com.sani.DemoApp;

import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentServices studentSevice;


    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentSevice.getAllStudents();
    }
}
