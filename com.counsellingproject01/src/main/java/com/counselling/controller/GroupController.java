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
import org.springframework.web.bind.annotation.RestController;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.Groups;
import com.counselling.serviceImpl.GroupServiceImpl;

@RestController
@RequestMapping(value = "groups")
@Validated
public class GroupController {

	/*
	 * @Autowired private GroupServiceImpl groupServiceImpl;
	 * 
	 * 
	 * 
	 * @PostMapping("/college/{collegeId}/groups")
	 * 
	 * public ResponseEntity<Groups> createGroups(@PathVariable(value = "collegeId")
	 * int collegeId,
	 * 
	 * @Valid @RequestBody Groups groups) {
	 * 
	 * return new ResponseEntity<>(groupServiceImpl.createGroup(collegeId, groups),
	 * HttpStatus.CREATED);
	 * 
	 * }
	 * 
	 * @GetMapping("/college/{collegeId}/groups")
	 * 
	 * public List<Groups> getGroupsByCollegeId(@PathVariable(value = "collegeId")
	 * int collegeId) {
	 * 
	 * return groupServiceImpl.getGroupsBycollegeId(collegeId);
	 * 
	 * }
	 * 
	 * @GetMapping("/college/{collegeId}/groups/{id}")
	 * 
	 * public ResponseEntity<Groups> getGroupsById(@PathVariable(value =
	 * "collegeId") int collegeId,
	 * 
	 * @PathVariable(value = "id") int id) {
	 * 
	 * Groups commentDto = groupServiceImpl.getGroupsById(collegeId, id);
	 * 
	 * return new ResponseEntity<>(commentDto, HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @PutMapping("/college/{collegeId}/groups/{id}")
	 * 
	 * public ResponseEntity<Groups> updateComment(@PathVariable(value =
	 * "collegeId") int collegeId,
	 * 
	 * @PathVariable(value = "id") int groupId,
	 * 
	 * @Valid @RequestBody Groups groups) {
	 * 
	 * Groups updatedgroup = groupServiceImpl.updateGroup(collegeId, groupId,
	 * groups);
	 * 
	 * return new ResponseEntity<>(updatedgroup, HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @DeleteMapping("/college/{collegeId}/groups/{id}")
	 * 
	 * public ResponseEntity<String> deleteComment(@PathVariable(value =
	 * "collegeId") int collegeId,
	 * 
	 * @PathVariable(value = "id") int groupId) {
	 * 
	 * groupServiceImpl.deleteGroup(collegeId, groupId);
	 * 
	 * return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
	 * 
	 * }
	 */

	@Autowired
	private GroupServiceImpl groupServiceImpl; 
	
	@PostMapping( value = "gcreate")
	public ResponseEntity<Groups> createGroups(@Valid @RequestBody Groups group) {
		
			Groups  groups = 	groupServiceImpl.createGroup(group);
				
				return new ResponseEntity<>(groups, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getall")
	public List<Groups>  getAllStudents() {
		return groupServiceImpl.getAllGroupss();
	}

	
	@GetMapping(value = "/getbyid/{id}")
	public Optional<Groups> getByIdStudent(@PathVariable("id") int id) throws ResourceNotFoundException {
	    Optional<Groups> groupsOptional = Optional.ofNullable(groupServiceImpl.getById(id));
	    return groupsOptional;
	}


	
	/*
	 * @GetMapping(value = "/getbyid") public Optional<Groups> getByIdStudent(int
	 * id) throws ResourceNotFoundException { return groupServiceImpl.getById(id);
	 * }
	 */
	
	@PutMapping(value = "update/{studentid}")
	public Groups updateGroup(@PathVariable("studentid") int  id ,Groups group)  throws ResourceNotFoundException{
		return groupServiceImpl.updateById(id, group);
	}
	@DeleteMapping(value = "delete/{id}")
	public void deleteGroup(@PathVariable("id") int  id ) throws ResourceNotFoundException {
		groupServiceImpl.deleteById(id);
	}

}
