package com.StudentManagement.dto;

import com.StudentManagement.entity.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDto extends BaseDto{

    @NotNull
    private Long id;

    private int standard;

    public ClassDto(Class classEntity){
        BeanUtils.copyProperties(classEntity, this, "createdOn", "updatedOn", "createdBy", "updatedBy");
    }
}
