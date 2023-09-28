package com.collegemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagementsystem.entity.CollegeEntity;
import com.collegemanagementsystem.entity.Groups;
import com.collegemanagementsystem.repository.GroupRepository;

@RestController
@RequestMapping(value="group")
public class GroupController {
	@Autowired
	private GroupRepository groupRepository;
	@PostMapping(value="create")
	
	public Groups createGroups(@RequestBody Groups group) {
		return groupRepository.save(group) ;
	}
	@GetMapping(value="readall")
	public List<Groups> readAllgroups(){
		return groupRepository.findAll();
	}
	

}
