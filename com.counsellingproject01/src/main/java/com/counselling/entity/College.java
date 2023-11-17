package com.counselling.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "college")
@Component
public class College {
   
//	@NotNull(message = "College code is required")
	@Id
    private int  collegeCode;
	
	@NotBlank(message = "College name is required")
	@Column(length = 25)
	private String collegeName;
	

	/*
	 * @Min(value = 450, message = "Minimum marks required must be at least 450")
	 * 
	 * @Max(value = 1000, message = "Minimum marks required cannot exceed 1000")
	 */
	

	@Range(min = 450,max= 1000, message = " marks required must be at least 450 and marks required cannot exceed 1000." )
	private int minMarksReq;
	
	@OneToMany(mappedBy = "college")
	@JsonIgnore
	private List<Groups> groups;
	


}




