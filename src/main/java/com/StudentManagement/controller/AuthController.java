package com.StudentManagement.controller;

import com.StudentManagement.annotation.APIResult;
import com.StudentManagement.dto.LoginDto;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @APIResult(message = "Login Success", error_message = "Login Failed")
    public Object studentLogin(@RequestBody LoginDto loginDto, HttpServletRequest request) throws SMException {
        return userService.login(loginDto);
    }
}
