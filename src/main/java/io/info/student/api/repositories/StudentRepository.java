package io.info.student.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.info.student.model.entities.Student;

public interface StudentRepository extends MongoRepository<Student,String>{}
