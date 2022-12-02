package com.StudentManagement.service;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.exception.SMException;

public interface StudentService {

    StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto) throws SMException;

//    StudentResponseDto studentDelete(Long id);
}

