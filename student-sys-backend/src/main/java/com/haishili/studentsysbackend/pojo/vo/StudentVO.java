package com.haishili.studentsysbackend.pojo.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentVO {
    private Long id;
    private String studentNo;
    private String name;
    private String gender;
    private String phone;
    private LocalDate birthday;
}
