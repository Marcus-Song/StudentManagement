package com.marcus.StudentSystem.service;

import com.marcus.StudentSystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public Optional<Student> selectStudentById(int id);
    public int deleteStudentById(int id);
    public int updateStudentById(int id, String name, String address);
    public Optional<Student> selectStudent(Student student);
    void updateStudent(Student student);
}
