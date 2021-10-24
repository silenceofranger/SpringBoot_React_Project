package io.nutrify.supplement.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.nutrify.supplement.model.entities.Student;

public interface StudentRepository extends MongoRepository<Student,String>{}
