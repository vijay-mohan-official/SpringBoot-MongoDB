package com.mongodb.learning.repository;

import com.mongodb.learning.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//Extending MongoRepository interface to perform CRUD operations in MongoDB
public interface StudentRepository extends MongoRepository<Student, ObjectId> {

}
