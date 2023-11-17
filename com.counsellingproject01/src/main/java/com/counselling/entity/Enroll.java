package com.counselling.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enroll")
public class Enroll {
	
	@Id
	private int enrollId;

	@ManyToOne
	@JoinColumn(name = "enroll_college_Code")
	private College college;

	@ManyToOne
	@JoinColumn(name = "enroll_student_Id")
	private Student student;
	

	@ManyToOne
	@JoinColumn(name = "enroll_group_Code")
	private Groups groups;

	

}
