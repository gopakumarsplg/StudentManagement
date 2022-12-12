package com.StudentManagement.service.impl;

import com.StudentManagement.dto.TeacherRegistrationDto;
import com.StudentManagement.dto.TeacherResponseDto;
import com.StudentManagement.entity.Teacher;
import com.StudentManagement.exception.SMException;
import com.StudentManagement.repository.ClassRepository;
import com.StudentManagement.repository.SubjectRepository;
import com.StudentManagement.repository.TeacherRepository;
import com.StudentManagement.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public TeacherResponseDto registerTeacher(TeacherRegistrationDto teacherRegistrationDto) throws SMException {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherRegistrationDto, teacher, "class_id", "subject_id");
        teacher.setClassTable(classRepository.findById(teacherRegistrationDto.getClass_id()).orElseThrow(() -> new SMException("#class.not.found", 0)));
        teacher.setSubject(subjectRepository.findById(teacherRegistrationDto.getSubject_id()).orElseThrow(()-> new SMException("#subject.not.found",0)));
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new TeacherResponseDto(savedTeacher);
    }
}
