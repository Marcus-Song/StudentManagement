package com.marcus.StudentSystem.service;

import com.marcus.StudentSystem.model.Teacher;
import com.marcus.StudentSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> selectTeacherById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
