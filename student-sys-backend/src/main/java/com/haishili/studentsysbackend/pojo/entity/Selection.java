package com.haishili.studentsysbackend.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Selection {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private LocalDateTime createTime;
}
