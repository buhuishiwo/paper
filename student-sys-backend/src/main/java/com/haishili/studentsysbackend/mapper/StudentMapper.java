package com.haishili.studentsysbackend.mapper;

import com.haishili.studentsysbackend.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from student where student_no = ${studentNo}")
    Student getByNo(int studentNo);
}
