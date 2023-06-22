package com.marcus.StudentSystem.controller;

import com.marcus.StudentSystem.model.Student;
import com.marcus.StudentSystem.model.Teacher;
import com.marcus.StudentSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public String add(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "New Teacher Added";
    }

    @GetMapping("/getAll")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        if (id <= 0)
            return "Invalid ID";
        if (teacherService.selectTeacherById(id).isEmpty())
            return "Teacher not found";

        teacherService.deleteTeacherById(id);
        return "Delete Successfully";
    }

    @PutMapping("/put/{id}")
    public String updateById(@PathVariable int id, @RequestBody Teacher request) {

        if (id <= 0) {
            return "Invalid ID";
        }

        Optional<Teacher> optionalTeacher = teacherService.selectTeacherById(id);
        if (optionalTeacher.isEmpty()) {
            return "Teacher not found";
        }

        Teacher teacher = optionalTeacher.get();
        if (!request.getName().isEmpty())
            teacher.setName(request.getName());
        if (!request.getSubject().isEmpty())
            teacher.setSubject(request.getSubject());
        if (!request.getPhone().isEmpty())
            teacher.setPhone(request.getPhone());
        teacherService.updateTeacher(teacher);

        return "Teacher Updated";
    }
}
