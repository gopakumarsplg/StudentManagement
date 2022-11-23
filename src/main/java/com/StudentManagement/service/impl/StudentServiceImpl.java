package com.StudentManagement.service.impl;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.entity.StudentEntity;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentRegistrationDto.getName());
        studentEntity.setEmail(studentRegistrationDto.getEmail());
        studentEntity.setBatch(studentRegistrationDto.getBatch());
        studentEntity.setPhone(studentRegistrationDto.getPhone());
        studentEntity.setGuardian(studentRegistrationDto.getGuardian());
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return new StudentResponseDto(savedEntity);
    }
}
