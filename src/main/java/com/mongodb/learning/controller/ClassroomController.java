package com.mongodb.learning.controller;

import com.mongodb.learning.entity.ClassRoom;
import com.mongodb.learning.entity.Student;
import com.mongodb.learning.service.ClassRoomService;
import com.mongodb.learning.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassRoomService service;

    @PostMapping
    public ClassRoom createEntry(@RequestBody ClassRoom classRoom){
        service.saveStudent(classRoom);
        return classRoom;
    }

    @GetMapping
    public List<ClassRoom> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClassRoom getById(@PathVariable ObjectId id){
        return service.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable ObjectId id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ClassRoom updateEntry(@PathVariable ObjectId id, @RequestBody ClassRoom classRoom){
        ClassRoom classRoomOld = service.findById(id).orElse(null);
        if(classRoomOld != null){
            classRoomOld.setClassName(classRoom.getClassName() != null && !classRoom.getClassName().equals("") ? classRoom.getClassName() : classRoomOld.getClassName());
        }
        classRoomOld.setDate(LocalDateTime.now());
        service.saveStudent(classRoomOld);
        return classRoomOld;
    }

}
