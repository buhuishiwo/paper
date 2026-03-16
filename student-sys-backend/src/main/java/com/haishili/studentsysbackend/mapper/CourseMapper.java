package com.haishili.studentsysbackend.mapper;

import com.haishili.studentsysbackend.pojo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    Course getCourseById(int id);

    int updateCourse(Course course);

    @Select("select * from course;")
    List<Course> getAllCourse();
}
