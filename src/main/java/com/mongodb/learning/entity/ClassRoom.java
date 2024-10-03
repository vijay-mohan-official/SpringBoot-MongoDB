package com.mongodb.learning.entity;

import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//To let Spring know that the below entity is mapped to a MongoDB collection
@Document(collection = "classroom")
public class ClassRoom {

    @Id
    private ObjectId id; //ObjectId is the default Id datatype of MongoDB

    @Indexed(unique = true)
    @NonNull
    private String className; //Indexed annotation is used so that only unique values are created

    private LocalDateTime date;

    @DBRef
    private List<Student> students = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
