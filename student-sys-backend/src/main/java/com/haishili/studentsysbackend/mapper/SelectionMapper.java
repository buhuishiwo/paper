package com.haishili.studentsysbackend.mapper;

import com.haishili.studentsysbackend.pojo.entity.Selection;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectionMapper {
    Selection findByStudentAndCourse(Integer studentId, Integer courseId);

    int insert(Selection selection);
}
