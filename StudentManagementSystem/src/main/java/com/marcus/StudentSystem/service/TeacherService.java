package com.marcus.StudentSystem.service;

import com.marcus.StudentSystem.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public List<Teacher> getAllTeacher();
    public Optional<Teacher> selectTeacherById(int id);
    public void deleteTeacherById(int id);
    public void updateTeacher(Teacher teacher);
}
