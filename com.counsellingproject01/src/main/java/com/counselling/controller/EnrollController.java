package com.counselling.controller;

import java.util.List;
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
import com.counselling.dto.EnrollDto;
import com.counselling.entity.CounsellingResult;
import com.counselling.entity.Enroll;
import com.counselling.repository.EnrollRepository;
import com.counselling.serviceImpl.EnrollService;

@RestController
@RequestMapping(value = "enroll")
public class EnrollController {
	@Autowired
	private EnrollService enrollService;
	@Autowired
	private EnrollRepository enrollRepository;
	
//	@PostMapping(value = "create")
//	public ResponseEntity<Enroll>  createstud(
//            @RequestParam int enroll_id,
//            @RequestParam int college_code,
//            @RequestParam int group_code,
//            @RequestParam int student_id) {
//		
//		Enroll enroll = enrollService.createEnroll(enroll_id, college_code, group_code, student_id);
//
//        return new ResponseEntity<>(enroll, HttpStatus.CREATED);
//		
//	} 
	
	/*
	 * @PostMapping(value = "/create") public EnrollDto createStudent(@RequestBody
	 * EnrollDto enrollDto) { return enrollService.createEnroll(enrollDto); }
	 */
	
	@GetMapping(value = "create")
	public ResponseEntity<Enroll> getCounsellingResult(@RequestParam int enrollId, int collegeCode,int studentId,int groupCode) throws ResourceNotFoundException {
		return new ResponseEntity<Enroll>( enrollService.createEnroll(enrollId, collegeCode,studentId,groupCode),HttpStatus.OK);
		
	}
	@GetMapping(value = "get/{enrollId}")
	public Optional<Enroll> createstud(@PathVariable int enrollId  ) {
		return enrollService.getByEnrollId(enrollId);
		
	}
	@GetMapping(value = "/getall")
	public List<Enroll>  getAllColleges() {
		return enrollRepository.findAll();
	}
	

} 






