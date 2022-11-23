package com.StudentManagement.controller;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.service.impl.StudentServiceImpl;
import com.StudentManagement.utils.Messages;
import com.StudentManagement.utils.RestApiStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<StudentResponseDto> studentRegister(@RequestBody StudentRegistrationDto studentRegistrationDto) throws Exception {
        try{
          StudentResponseDto studentEntity = studentService.studentRegister(studentRegistrationDto);
          StudentResponseDto studentResponseDto = new StudentResponseDto();
          studentResponseDto.setMessage(Messages.STUDENT_REGISTER_SUCCESS);
          studentResponseDto.setData(studentEntity.getData());
          studentResponseDto.setStatus(Messages.SUCCESS);
          studentResponseDto.setStatusCode(RestApiStatusCode.SUCCESS);
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        }
        catch (Exception e){
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setStatus(Messages.ERROR);
            studentResponseDto.setStatusCode(RestApiStatusCode.BAD_REQUEST);
            studentResponseDto.setMessage(e.getMessage()  !=null ? e.getMessage() : Messages.STUDENT_REGISTER_FAILED );
            return new ResponseEntity<>(studentResponseDto ,HttpStatus.BAD_REQUEST);
        }
    }
}
