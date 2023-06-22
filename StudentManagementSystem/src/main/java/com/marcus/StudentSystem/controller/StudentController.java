package com.marcus.StudentSystem.controller;

import com.marcus.StudentSystem.model.Student;
import com.marcus.StudentSystem.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New Student Added";
    }

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteById(@PathVariable int id) {
        if (id <= 0) {
            return "Invalid ID";
        }
        studentService.deleteStudentById(id);
        return "Delete Successfully";
    }

    @PutMapping("/put/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String updateById(@PathVariable int id, @RequestBody Student request) {

        if (id <= 0) {
            return "Invalid ID";
        }

        Optional<Student> optionalStudent = studentService.selectStudentById(id);
        if (optionalStudent.isEmpty()) {
            return "Student not found";
        }

        Student student = optionalStudent.get();
        if (!request.getName().isEmpty())
            student.setName(request.getName());
        if (!request.getAddress().isEmpty())
            student.setAddress(request.getAddress());
        if (!request.getMajor().isEmpty())
            student.setMajor(request.getMajor());
        if (!request.getPhone().isEmpty())
            student.setPhone(request.getPhone());
        studentService.updateStudent(student);

        return "Student Updated";
    }

}
