package com.haishili.studentsysbackend.pojo.entity;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String courseName;
    private String teacher;
    private Integer maxCapacity;
    private Integer selectedCount;
}
