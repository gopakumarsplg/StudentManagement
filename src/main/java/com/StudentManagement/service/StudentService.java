package com.StudentManagement.service;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;

public interface StudentService {

    public StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto);
    }

