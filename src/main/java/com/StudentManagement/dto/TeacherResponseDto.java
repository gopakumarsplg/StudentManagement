package com.StudentManagement.dto;

import com.StudentManagement.entity.Teacher;
import com.StudentManagement.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherResponseDto extends BaseDto{

    private String name;

    private String email;

    private String address;

    private int phone;

    private String place;

    private Long class_id;

    private Long subject_Id;

    private String userName;

    private Long userId;

    public TeacherResponseDto(Teacher savedTeacher, User savedUser){
        this.name = savedTeacher.getName();
        this.address = savedTeacher.getAddress();
        this.phone = savedTeacher.getPhone();
        this.place = savedTeacher.getPlace();
        this.email = savedTeacher.getEmail();
        this.class_id = savedTeacher.getClassTable().getId();
        this.subject_Id = savedTeacher.getSubject().getId();
        this.userName = savedUser.getUsername();
        this.userId = savedUser.getId();
    }
}
