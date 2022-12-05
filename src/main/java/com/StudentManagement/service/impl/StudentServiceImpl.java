package com.StudentManagement.service.impl;

import com.StudentManagement.dto.BaseDto;
import com.StudentManagement.dto.LoginDto;
import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.entity.Student;
import com.StudentManagement.entity.User;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.repository.ClassRepository;
import com.StudentManagement.repository.RoleRepository;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.repository.UserRepository;
import com.StudentManagement.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public StudentResponseDto studentRegister(StudentRegistrationDto studentRegistrationDto) throws SMException {
        Student student = new Student();
        BeanUtils.copyProperties(studentRegistrationDto, student, "password", "id", "classId");
        student.setClassId(classRepository.findById(studentRegistrationDto.getClassId()).orElseThrow(() -> new SMException("#class.not.found", 0)));
        User user = new User();
        user.setUsername(studentRegistrationDto.getUsername());
        user.setPassword(encoder.encode(studentRegistrationDto.getPassword()));
        try {
            userRepository.save(user);
            student.setUserId(userRepository.getReferenceById(user.getId()));
            student.setRoleId(roleRepository.findById(studentRegistrationDto.getRoleId()).get());
        } catch (DataIntegrityViolationException e) {
            throw new SMException("#user.already.exist", 0);
        }
         Student savedEntity = saveStudent(student);
        return new StudentResponseDto(savedEntity, user.getUsername());
    }

    private Student saveStudent(Student student) throws SMException{
        try {
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new SMException("#student.already.exist", 0);
        }
    }

    //    @Override
//    public StudentResponseDto studentDelete(Long id) {
//        Optional<Student> studentEntity = studentRepository.findById(id);
//        if (studentEntity != null && studentEntity.get().getIsDeleted() != false) {
//            studentEntity.get().setIsDeleted(true);
//        }
//        return new StudentResponseDto(studentEntity.get());
//    }

}