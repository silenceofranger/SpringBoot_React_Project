package io.info.student.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.info.student.api.repositories.StudentRepository;
import io.info.student.model.entities.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> GetUser() {
        return studentRepository.findAll();
    }
    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @GetMapping("/{id}")
    public Student GetUser(@PathVariable String id) {
        return studentRepository.findById(id).orElse(null);
    }
    @PutMapping("/")
    public Student PutMapping(@RequestBody Student newStudent) {
        Student oldStudent = studentRepository.findById(newStudent.getId()).orElse(null);
        oldStudent.setName(newStudent.getName());
        oldStudent.setEmail(newStudent.getEmail());
        oldStudent.setPassword(newStudent.getPassword());
        studentRepository.save(oldStudent);
        return oldStudent;
    }
    @DeleteMapping("/{id}")
    public String DeleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
        return id;
    }
}