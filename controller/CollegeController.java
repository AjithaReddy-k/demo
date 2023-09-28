package com.collegemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.entity.CollegeEntity;
import com.collegemanagementsystem.entity.StudentEntity;
import com.collegemanagementsystem.repository.CollegeRepository;

@RestController
@RequestMapping(value="college")
public class CollegeController {
	@Autowired
	private CollegeRepository collegeRepository;
	@PostMapping(value = "create")
	public CollegeEntity createStudent(@RequestBody CollegeEntity student) {
		return collegeRepository.save(student);
	
	}
	@GetMapping(value="readall")
	public List<CollegeEntity> readAllcolleges(){
		return collegeRepository.findAll();
	}
		
	

}
