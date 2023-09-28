package com.collegemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Table(name="collegedetails")

public class CollegeEntity {
	@Id
	private int collegeCode;
	@Column(name="clg_name")
	private String collegeName;
	@Column(name="clg_cat")
	private char collegeCategory;
	//List<StudentEntity>listOfSudents;
	//  @OneToMany(mappedBy = "college")
	//    private List<Groups> groups;

	

}
