package com.StudentManagement.service;

import com.StudentManagement.dto.TeacherRegistrationDto;
import com.StudentManagement.dto.TeacherResponseDto;
import com.StudentManagement.exception.SMException;

public interface TeacherService {

    TeacherResponseDto registerTeacher(TeacherRegistrationDto teacherRegistrationDto) throws SMException;
}
