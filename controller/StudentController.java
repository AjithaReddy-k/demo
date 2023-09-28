package com.collegemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.entity.StudentEntity;
import com.collegemanagementsystem.repository.StudentRepository;

@RestController
@RequestMapping(value="student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping(value = "create")
	public StudentEntity createStudent(@RequestBody StudentEntity student) {
		return studentRepository.save(student);
	
	}
	@GetMapping(value="readall")
	public List<StudentEntity> readAllStudents(){
		return studentRepository.findAll();
		
	}

}
