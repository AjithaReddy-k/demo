package com.counselling.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "counselling_result")
@Component
public class CounsellingResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int reslutId;
	
	@ManyToOne
	@JoinColumn(name = "enroll_id")
	@JsonIgnore
	private Enroll enroll;
	@Column(length = 25)
	private String enrolledStudentName;
	@Column(length = 20)
	private String selectedCollegeName;
	@Column(length = 5)
	private String selectedGroupName;
	@Column(length = 15)
	private String result;

//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	@JsonIgnore
//	private Student student;
//	
//	@ManyToOne
//	@JoinColumn(name = "collge_code")
//	@JsonIgnore
//	private College college;

//	@ManyToOne

//	@JoinColumn(name = "collegeCode")
//	private College college;

//	@ManyToOne
//	@JoinColumn(name = "college_name")
//	private College college;
//
//	@ManyToOne
//	@JoinColumn(name = "group_name")
//	private Groups groups;

	
	
	
}
