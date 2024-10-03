package com.mongodb.learning.service;

import com.mongodb.learning.entity.Student;
import com.mongodb.learning.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> getAll(){
       return repository.findAll();
    }

    public Optional<Student> findById(ObjectId id) {
        return repository.findById(id);
    }

    public boolean deleteById(ObjectId id) {
        repository.deleteById(id);
        return true;
    }
}
