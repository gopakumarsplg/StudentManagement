package com.StudentManagement.service.impl;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.entity.Student;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.repository.ClassRepository;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto) throws SMException {
        Student student = new Student();
        BeanUtils.copyProperties(studentRegistrationDto,student,"password","id","classId");
        student.setClassId(classRepository.findById(studentRegistrationDto.getClassId()).orElseThrow(() -> new SMException("#class.not.found",0)));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        student.setPassword(encoder.encode(studentRegistrationDto.getPassword()));
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