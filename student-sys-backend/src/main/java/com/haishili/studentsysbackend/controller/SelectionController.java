package com.haishili.studentsysbackend.controller;

import com.haishili.studentsysbackend.common.Result;
import com.haishili.studentsysbackend.mapper.CourseMapper;
import com.haishili.studentsysbackend.pojo.entity.Selection;
import com.haishili.studentsysbackend.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/selection")
public class SelectionController {

    @Autowired
    private SelectionService selectionService;

    @PostMapping("/select")
    public Result<?> select(@RequestBody Selection selection) throws Exception {
        return selectionService.selectByStudentAndCourse(selection.getStudentId(), selection.getCourseId());
    }
}
