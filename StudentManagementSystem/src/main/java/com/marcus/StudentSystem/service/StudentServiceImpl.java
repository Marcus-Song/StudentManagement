package com.marcus.StudentSystem.service;

import com.marcus.StudentSystem.model.Student;
import com.marcus.StudentSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> selectStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public int deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return 1;
    }

    @Override
    public int updateStudentById(int id, String name, String address) {
        Student student = studentRepository.findById(id).orElseThrow();
        if (name != null) student.setName(name);
        if (address != null) student.setAddress(address);
        studentRepository.save(student);
        return 1;
    }

    @Override
    public Optional<Student> selectStudent(Student student) {
        int id = student.getId();
        return studentRepository.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

}
