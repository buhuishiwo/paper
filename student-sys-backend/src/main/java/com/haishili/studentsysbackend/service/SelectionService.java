package com.haishili.studentsysbackend.service;

import com.haishili.studentsysbackend.common.Result;
import com.haishili.studentsysbackend.pojo.entity.Course;
import org.springframework.stereotype.Service;

@Service
public interface SelectionService {
    Result<?> selectByStudentAndCourse(Integer studentId, Integer courseId) throws InterruptedException;
}
