package com.StudentManagement.service;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;

public interface StudentService {

    StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto);

    StudentResponseDto studentDelete(Long id);
}

