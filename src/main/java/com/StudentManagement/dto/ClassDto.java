package com.StudentManagement.dto;

import org.springframework.beans.BeanUtils;

public class ClassDto extends BaseDto{

    private Long id;

    private int standard;

    public ClassDto(Class classEntity){
        BeanUtils.copyProperties(classEntity, this, "createdOn", "updatedOn", "createdBy", "updatedBy");
    }
}
