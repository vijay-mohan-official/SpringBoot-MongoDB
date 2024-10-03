package com.mongodb.learning.controller;

import com.mongodb.learning.entity.Student;
import com.mongodb.learning.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student createEntry(@RequestBody Student student){
        student.setDate(LocalDateTime.now());
        service.saveStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable ObjectId id){
        return service.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable ObjectId id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student updateEntry(@PathVariable ObjectId id, @RequestBody Student student){
        Student student1 = service.findById(id).orElse(null);
        if(student1 != null){
            student1.setName(student.getName() != null && !student.getName().equals("") ? student.getName() : student1.getName());
            student1.setAge(student.getAge() != student1.getAge() ? student.getAge() : student1.getAge());
        }
        student1.setDate(LocalDateTime.now());
        service.saveStudent(student1);
        return student1;
    }

}
