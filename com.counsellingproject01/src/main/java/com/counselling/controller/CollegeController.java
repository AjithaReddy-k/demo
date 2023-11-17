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
import com.counselling.entity.College;
import com.counselling.serviceImpl.CollegeService;



@RestController
@RequestMapping(value = "college")
@Validated
public class CollegeController {
	
    @Autowired
	private CollegeService collegeService;

	@PostMapping(value = "/create")
	public ResponseEntity<College>  createCollege(@Valid @RequestBody College college) {
		College college1 = collegeService.createCollege(college);
		
		return new ResponseEntity<>(college1, HttpStatus.CREATED);
	}
	@GetMapping(value = "/getall")
	public List<College>  getAllColleges() {
		return collegeService.getAllColleges();
	}
	
	@GetMapping(value = "/getbyid/{code}")
	public College getByIdCollege(@PathVariable("code") int code) throws ResourceNotFoundException{
	    return collegeService.getById(code);
	}

	
	
	
	/*
	 * @GetMapping(value = "/getbyid/{code}") public College
	 * getByIdCollege(@PathVariable("code") int code) { Optional<College>
	 * collegeOptional = collegeService.getById(code);
	 * 
	 * if (collegeOptional.isPresent()) { return collegeOptional.get(); // Return
	 * the College if it exists } else { throw new
	 * ResourceNotFoundException("College not found with code: " + code); } }
	 */

	
	/*
	 * @GetMapping(value = "/getbyid/{code}") public Optional<College>
	 * getByIdCollege( @PathVariable("code") int code) throws
	 * ResourceNotFoundException{ return collegeService.getById(code); }
	 */
	@PutMapping(value = "update/{Collegeid}")
	public College updateCollege(@PathVariable("Collegeid") int  code ,College college) throws ResourceNotFoundException{
		return collegeService.updateById(code, college);
	}
	@DeleteMapping(value = "delete")
	public void deleteCollege(@RequestParam int code ) throws ResourceNotFoundException{
		collegeService.deleteById(code);
	}
}
