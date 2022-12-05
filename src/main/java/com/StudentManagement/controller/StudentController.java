package com.StudentManagement.controller;

import com.StudentManagement.annotation.APIResult;
import com.StudentManagement.dto.LoginDto;
import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.service.impl.StudentServiceImpl;
import com.StudentManagement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/student/register", method = RequestMethod.POST)
    @APIResult(message ="#student.register.success", error_message ="#student.register.failed")
    public Object studentRegister(@RequestBody StudentRegistrationDto studentRegistrationDto) throws SMException {
        return studentService.studentRegister(studentRegistrationDto);
    }

//    @RequestMapping(value ="/student/delete/{id}", method = RequestMethod.DELETE)
//    @APIResult(message = "", error_message = "", message_code = 1)
//    public Object studentDelete(@PathVariable(value = "id")Long id) {
//        return studentService.studentDelete(id);
//    }

    @RequestMapping("/login")
    @APIResult(message = "Login Success", error_message = "Login Failed")
    public Object studentLogin(@RequestBody LoginDto loginDto) throws SMException{
        return userService.login(loginDto);
    }
}
