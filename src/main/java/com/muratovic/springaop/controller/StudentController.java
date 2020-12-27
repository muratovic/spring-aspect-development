package com.muratovic.springaop.controller;

import com.muratovic.springaop.domain.Student;
import com.muratovic.springaop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createDriver(@RequestBody Student student)
    {
        return studentService.create(student);
    }
}
