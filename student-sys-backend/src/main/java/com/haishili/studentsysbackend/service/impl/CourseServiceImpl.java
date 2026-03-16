package com.haishili.studentsysbackend.service.impl;

import com.haishili.studentsysbackend.mapper.CourseMapper;
import com.haishili.studentsysbackend.pojo.entity.Course;
import com.haishili.studentsysbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }
}
