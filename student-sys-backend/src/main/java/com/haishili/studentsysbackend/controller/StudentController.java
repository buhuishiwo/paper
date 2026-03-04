package com.haishili.studentsysbackend.controller;

import com.haishili.studentsysbackend.common.ResponseCode;
import com.haishili.studentsysbackend.common.Result;
import com.haishili.studentsysbackend.pojo.dto.StudentLoginDTO;
import com.haishili.studentsysbackend.pojo.vo.StudentVO;
import com.haishili.studentsysbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Result<StudentVO> login (@RequestBody StudentLoginDTO studentLoginDTO){
        return Result.success(studentService.Login(studentLoginDTO));
    }

}
