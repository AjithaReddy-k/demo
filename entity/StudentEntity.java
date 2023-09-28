package com.collegemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="studentdetails")
public class StudentEntity {
	@Id
	private int studentId;
	@Column(name="std_name")
	private String studentName;
	@Column(name="std_grp")
	private String studentGroup;
	private int age;
	private char gender;
	

	

}
