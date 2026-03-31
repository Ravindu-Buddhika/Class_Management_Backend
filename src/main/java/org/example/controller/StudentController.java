package org.example.controller;

import org.example.model.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ArrayList<Student>getall(){
        return studentService.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
}
