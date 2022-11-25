package com.StudentManagement.service.impl;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto) {
        Student student = new Student();
        student.setName(studentRegistrationDto.getName());
        student.setEmail(studentRegistrationDto.getEmail());
        student.setBatch(studentRegistrationDto.getBatch());
        student.setPhone(studentRegistrationDto.getPhone());
        student.setGuardian(studentRegistrationDto.getGuardian());
        student.setAddress(studentRegistrationDto.getAddress());
        Student savedEntity = studentRepository.save(student);
        return new StudentResponseDto(savedEntity);
    }

    @Override
    public StudentResponseDto studentDelete(Long id) {
        Optional<Student> studentEntity = studentRepository.findById(id);
        if (studentEntity != null && studentEntity.get().getIsDeleted() != false) {
            studentEntity.get().setIsDeleted(true);
        }
        return new StudentResponseDto(studentEntity.get());
    }
}