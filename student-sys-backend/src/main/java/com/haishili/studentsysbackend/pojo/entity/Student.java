package com.haishili.studentsysbackend.pojo.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
    private Long id;
    private String studentNo;
    private String name;
    private String password;
    private String gender;
    private String phone;
    private LocalDate birthday;
}
