package com.haishili.studentsysbackend.service.impl;

import com.haishili.studentsysbackend.common.ResponseCode;
import com.haishili.studentsysbackend.common.exception.BusinessException;
import com.haishili.studentsysbackend.mapper.StudentMapper;
import com.haishili.studentsysbackend.pojo.dto.StudentLoginDTO;
import com.haishili.studentsysbackend.pojo.entity.Student;
import com.haishili.studentsysbackend.pojo.vo.StudentVO;
import com.haishili.studentsysbackend.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentVO Login(StudentLoginDTO studentLoginDTO) {
        Student student = studentMapper.getByNo(studentLoginDTO.getUsername());
        if(student == null) {
            throw new BusinessException(ResponseCode.LOGIN_ERROR.getCode(),
                    ResponseCode.LOGIN_ERROR.getMessage());
        } else {
            if(!student.getPassword().equals(studentLoginDTO.getPassword())){
                throw new BusinessException(ResponseCode.LOGIN_ERROR.getCode(),
                        ResponseCode.LOGIN_ERROR.getMessage());
            }
        }
        return convertToVO(student);
    }

    @Override
    public StudentVO convertToVO(Student student) {
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        return studentVO;
    }

}
