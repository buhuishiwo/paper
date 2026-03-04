package com.haishili.studentsysbackend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.haishili.studentsysbackend.mapper")
public class MyBatisConfig {
}
