package com.StudentManagement.controller;

import com.StudentManagement.annotation.APIResult;
import com.StudentManagement.dto.TeacherRegistrationDto;
import com.StudentManagement.dto.TeacherResponseDto;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/register", method = RequestMethod.POST)
    @APIResult(message = "#teacher.register.success", error_message = "#teacher.register.failed")
    public Object registerTeacher(@Valid @RequestBody TeacherRegistrationDto teacherRegistrationDto) throws SMException {
            return teacherService.registerTeacher(teacherRegistrationDto);
    }
}
