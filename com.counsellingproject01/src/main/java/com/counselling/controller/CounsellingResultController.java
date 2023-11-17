package com.counselling.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.College;
import com.counselling.entity.CounsellingResult;
import com.counselling.entity.Enroll;
import com.counselling.entity.Student;
import com.counselling.serviceImpl.CollegeService;
import com.counselling.serviceImpl.CounsellingResultService;
import com.counselling.serviceImpl.StudentService;

@RestController
@RequestMapping("Result")
public class CounsellingResultController {
	
	@Autowired
	private CounsellingResultService counsellingResultService;
	
	@Autowired
	private CollegeService collegeService;
	
	@Autowired
	private StudentService studentService;
	
	
//	  @PostMapping(value = "/create") public CounsellingResult
//	  createResult(@RequestBody CounsellingResult counsellingResult, int enrollId)
//	  { return counsellingResultService.createResult(counsellingResult, enrollId);
//	  }
	 
	
	@GetMapping(value = "getresult")
	public ResponseEntity<CounsellingResult> getCounsellingResult(@RequestParam int collegeCode,int studentId,int enrollId) throws ResourceNotFoundException {
		return new ResponseEntity<CounsellingResult>( counsellingResultService.findCounsellingResult( collegeCode,studentId,enrollId),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "getresultdetails")
	public ResponseEntity<CounsellingResult> getCounsellingResult(@RequestParam int enrollId) throws ResourceNotFoundException {
		return new ResponseEntity<CounsellingResult>( counsellingResultService.getresultDeatils(enrollId),HttpStatus.OK);
		
	}
	
	
	
	
//	  @GetMapping(value = "getbycollegecode") public College
//	  getByCollegeCode(@RequestParam int code) throws ResourceNotFoundException {
//	  return collegeService.getMinMarks(code); }
//	  
//	  @GetMapping(value = "getbystudentid") public Student
//	  getByStudentId(@RequestParam int studentId) { return
//	  studentService.getMarks(studentId); }
//	 
	
}
