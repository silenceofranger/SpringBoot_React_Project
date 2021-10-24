package io.nutrify.supplement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.nutrify.supplement.api.repositories.StudentRepository;
import io.nutrify.supplement.model.entities.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class Controller {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> GetUser() {
        return studentRepository.findAll();
    }
    @PostMapping("/")
    public Student SaveProduct(@RequestBody Student product) {
        return studentRepository.save(product);
    }
    @GetMapping("/{id}")
    public Student GetUser(@PathVariable String id) {
        return studentRepository.findById(id).orElse(null);
    }
    @PutMapping("/")
    public Student PutMapping(@RequestBody Student newStudent) {
        Student oldStudent = studentRepository.findById(newStudent.getId()).orElse(null);
        oldStudent.setName(newStudent.getName());
        oldStudent.setAddress(newStudent.getAddress());
        oldStudent.setStandard(newStudent.getStandard());
        studentRepository.save(oldStudent);
        return oldStudent;
    }
    @DeleteMapping("/{id}")
    public String DeleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
        return id;
    }
}