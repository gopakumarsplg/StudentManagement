package com.StudentManagement.controller;

import com.StudentManagement.dto.StudentRegistrationDto;
import com.StudentManagement.dto.StudentResponseDto;
import com.StudentManagement.service.impl.StudentServiceImpl;
import com.StudentManagement.utils.Messages;
import com.StudentManagement.utils.RestApiStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;
    @RequestMapping(value = "/student/register", method = RequestMethod.POST)
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

    @RequestMapping(value ="/student/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StudentResponseDto> studentDelete(@PathVariable(value = "id")Long id){
        try {
            StudentResponseDto studentEntity = studentService.studentDelete(id);
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setData(studentEntity.getData());
            studentResponseDto.setMessage(Messages.SUCCESS);
            studentResponseDto.setStatus(Messages.STUDENT_DELETE_SUCCESS);
            studentResponseDto.setStatusCode(RestApiStatusCode.SUCCESS);
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setMessage(Messages.ERROR);
            studentResponseDto.setStatus(e.getMessage() !=null ? e.getMessage() : Messages.STUDENT_DELETE_FAILED);
            studentResponseDto.setStatusCode(RestApiStatusCode.BAD_REQUEST);
            return new ResponseEntity<>(studentResponseDto, HttpStatus.BAD_REQUEST);
        }

    }
}
