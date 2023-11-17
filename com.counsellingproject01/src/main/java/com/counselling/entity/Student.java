package com.counselling.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name="Students")
public class Student {
	@Id
	private int studentId;
	
	@NotBlank(message = "Student name is required")
    @Size(max = 20, message = "StudentS name must be less than or equal to 25 characters")
	@Column(length = 25)
	private String studentName;
	
	@Range(min = 450,max= 1000, message = " marks required must be at least 450 and marks required cannot exceed 1000." )
	private Integer studentMarks;
	
	@NotBlank(message = "studentUgGroup  is required")
	@Column(length = 5)
	private String studentUgGroup;
	
 


	
	

}
