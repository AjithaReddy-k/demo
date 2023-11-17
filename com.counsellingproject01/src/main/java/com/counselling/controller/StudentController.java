package com.counselling.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.Student;
import com.counselling.serviceImpl.StudentService;



@RestController
@RequestMapping(value = "student")
@Validated
public class StudentController {
	
    @Autowired
	private StudentService studentService;

	@PostMapping(value = "/create")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		
			Student students = 	studentService.createStudent(student);
				return new ResponseEntity<>(students, HttpStatus.CREATED);
				
	}
	@GetMapping(value = "/getall")
	public List<Student>  getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(value = "/getbyid/{id}")
	public Optional<Student>  getByIdStudent(@PathVariable int id)  throws ResourceNotFoundException{
		Optional<Student> studentOptional = Optional.of(studentService.getById(id));
		return studentOptional;
	}
	@PutMapping(value = "update/")
	public Student updateStudent(@RequestParam int  id ,Student student)throws ResourceNotFoundException {
		return studentService.updateById(id, student);
	}

	
	@DeleteMapping("delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId)throws ResourceNotFoundException {
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok("Student with ID " + studentId + " deleted successfully.");
    }
}
