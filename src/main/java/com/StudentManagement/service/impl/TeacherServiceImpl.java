package com.StudentManagement.service.impl;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.TeacherRegistrationDto;
import com.StudentManagement.dto.TeacherResponseDto;
import com.StudentManagement.entity.Role;
import com.StudentManagement.entity.Teacher;
import com.StudentManagement.entity.User;
import com.StudentManagement.entity.UserRole;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.repository.*;
import com.StudentManagement.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public TeacherResponseDto registerTeacher(TeacherRegistrationDto teacherRegistrationDto) throws SMException {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherRegistrationDto, teacher, "class_id", "subject_id");
        teacher.setClassTable(classRepository.findById(teacherRegistrationDto.getClassId()).orElseThrow(() -> new SMException("#class.not.found", 0)));
        teacher.setSubject(subjectRepository.findById(teacherRegistrationDto.getSubjectId()).orElseThrow(()-> new SMException("#subject.not.found",0)));
        Teacher savedTeacher = teacherRepository.save(teacher);
        User savedUser = saveUser(teacherRegistrationDto);
        return new TeacherResponseDto(savedTeacher, savedUser);
    }

    private User saveUser(TeacherRegistrationDto studentRegistrationDto) throws SMException {
        User user = new User();
        user.setUsername(studentRegistrationDto.getUserName());
        user.setPassword(encoder.encode(studentRegistrationDto.getPassword()));
        try {
            userRepository.save(user);
            ArrayList<Long> roles = studentRegistrationDto.getRoleId();
            for (Long roleId : roles) {
                Role role = roleRepository.findById(roleId).orElseThrow(()-> new SMException("#role.not.found"));
                UserRole userRole = new UserRole(user, role);
                userRoleRepository.save(userRole);
            }
        } catch (DataIntegrityViolationException e) {
            throw new SMException("#user.already.exist", 0);
        }
        return user;
    }
}
