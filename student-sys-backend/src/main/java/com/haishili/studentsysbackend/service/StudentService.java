package com.haishili.studentsysbackend.service;

import com.haishili.studentsysbackend.pojo.dto.StudentLoginDTO;
import com.haishili.studentsysbackend.pojo.entity.Student;
import com.haishili.studentsysbackend.pojo.vo.StudentVO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentVO Login(StudentLoginDTO studentLoginDTO);
    StudentVO convertToVO(Student student);
}
