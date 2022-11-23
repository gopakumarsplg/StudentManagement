package com.StudentManagement.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
//import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
//import javax.persistence.OneToOne;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_on", insertable = true, updatable = true)
    protected Date createdOn;

    @Column(name = "updated_on", insertable = true, updatable = true)
    protected Date updatedOn;

//    @OneToOne(targetEntity = Admin.class, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "created_by")
    protected String createdBy;

    @JoinColumn(name = "updated_by")
//    @OneToOne(targetEntity= Admin.class, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    protected String updatedBy;
}
