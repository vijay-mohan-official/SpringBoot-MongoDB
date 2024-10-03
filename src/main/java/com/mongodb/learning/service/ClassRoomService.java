package com.mongodb.learning.service;

import com.mongodb.learning.entity.ClassRoom;
import com.mongodb.learning.entity.Student;
import com.mongodb.learning.repository.ClassRoomRepository;
import com.mongodb.learning.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository repository;

    public void saveStudent(ClassRoom classRoom){
        repository.save(classRoom);
    }

    public List<ClassRoom> getAll(){
       return repository.findAll();
    }

    public Optional<ClassRoom> findById(ObjectId id) {
        return repository.findById(id);
    }

    public boolean deleteById(ObjectId id) {
        repository.deleteById(id);
        return true;
    }
}
