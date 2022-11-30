//package com.StudentManagement.entity;
//
//import com.StudentManagement.entity.listeners.EntityListener;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "tb_teacher_role", uniqueConstraints = {
//		@UniqueConstraint(columnNames = { "role"}, name = "tr_role") })
//@Where(clause = "deleted = false")
//@EntityListeners(EntityListener.class)
//public class TeacherRole extends BaseEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private String role;
//
//	private String roleAMMC;
//
//	private String displayName;
//
//	@Column(columnDefinition = "BIT not null default 0")
//	private Boolean predefined;
//
//	public TeacherRole(String role, String roleAMMC, String displayName, Boolean predefined) {
//		super();
//		this.role = role;
//		this.roleAMMC = roleAMMC;
//		this.displayName = displayName;
//		this.predefined = predefined;
//	}
//
//
//}
