package com.counselling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.counselling.entity.Groups;

@Service
public interface GroupsService {
	public abstract Groups createGroup(int collegeId, Groups groups);

	 

	public abstract List<Groups> getGroupsBycollegeId(int collegeId);

 

	public abstract Groups getGroupsById(int collegeId, int groupId);

 

	public abstract  Groups updateGroup(int collegeId, int groupId, Groups groupRequest);

 

	public abstract void deleteGroup(int collegeId, int groupId);

}
