package com.haishili.studentsysbackend.controller;

import com.haishili.studentsysbackend.common.Result;
import com.haishili.studentsysbackend.pojo.entity.Course;
import com.haishili.studentsysbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("list")
    public Result<List<Course>> getAllCourse(){
        List<Course> courseList = courseService.getAllCourse();
        return Result.success(courseList);
    }
}
