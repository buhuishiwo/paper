package com.haishili.studentsysbackend.service.impl;

import com.haishili.studentsysbackend.common.Result;
import com.haishili.studentsysbackend.mapper.CourseMapper;
import com.haishili.studentsysbackend.mapper.SelectionMapper;
import com.haishili.studentsysbackend.pojo.entity.Course;
import com.haishili.studentsysbackend.pojo.entity.Selection;
import com.haishili.studentsysbackend.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SelectionServiceImpl implements SelectionService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SelectionMapper selectionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> selectByStudentAndCourse(Integer studentId, Integer courseId) throws InterruptedException {

        Course course = courseMapper.getCourseById(courseId);
        if (course == null) {
            return Result.error("课程不存在");
        }

        Selection exist = selectionMapper.findByStudentAndCourse(studentId, courseId);
        if (exist != null) {
            return Result.error("课程已选");
        }

        if(course.getSelectedCount() >= course.getMaxCapacity()){
            return Result.error("课程已选满");
        }
        Thread.sleep(300);

        Selection selection = new Selection();
        selection.setStudentId(studentId);
        selection.setCourseId(courseId);
        selection.setCreateTime(LocalDateTime.now());
        selectionMapper.insert(selection);

        course.setSelectedCount(course.getSelectedCount() + 1);
        courseMapper.updateCourse(course);

        return Result.success("选课成功");
    }
}
