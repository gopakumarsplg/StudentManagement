package com.StudentManagement.entity.listeners;


import com.StudentManagement.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Component
public class EntityListener {

	private static EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManager em) {
		entityManager = em;
	}

	@PrePersist
	public void beforeSave(final BaseEntity reference) {
		Date current = new Date();
		reference.setCreatedOn(current);
		reference.setUpdatedOn(current);
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(authentication != null) {
//			Object principal = authentication.getPrincipal();
//			if(principal != null && principal instanceof SubjectDto) {
//				SubjectDto subjectDto = (SubjectDto) principal;
//				reference.setCreatedBy(entityManager.getReference(Admin.class, subjectDto.getId()));
//			}
//		}
	}

	@PreUpdate
	public void beforeUpdate(final BaseEntity reference) {
		reference.setUpdatedOn(new Date());
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(authentication != null) {
//			Object principal = authentication.getPrincipal();
//			if(principal != null && principal instanceof SubjectDto) {
//				SubjectDto subjectDto = (SubjectDto) principal;
//				reference.setUpdatedBy(entityManager.getReference(Admin.class, subjectDto.getId()));
//			}
//		}
	}

}
