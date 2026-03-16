package com.haishili.studentsysbackend.service;

import com.haishili.studentsysbackend.pojo.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourse();
}
