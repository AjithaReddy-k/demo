package com.counselling.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.counselling.Exceptions.AppApiExceptions;
import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.College;
import com.counselling.entity.Groups;
import com.counselling.repository.CollegeRepository;
import com.counselling.repository.GroupsRepository;
import com.counselling.service.GroupsService;

@Service
public class GroupServiceImpl {
//	
//	@Autowired
//	private CollegeRepository collegeRepository;
//	
//	@Autowired
//	private GroupsRepository groupsRepository;
//
//	@Autowired
//	private Groups groups;
//	
//	@Override
//	public Groups createGroup(int collegeId, Groups groups) {
//	
//
//		 
//
//        // retrieve post entity by id
//
//        College college = collegeRepository.findById(collegeId).orElseThrow(
//
//                () -> new ResourceNotFoundException("College", "code", collegeId));
//
// 
//
//        // set post to comment entity
//
//        groups.setCollege(college);
//
// 
//
//        // comment entity to DB
//
//        Groups newGroup =  groupsRepository.save(groups);
//
// 
//
//        return newGroup;
//	}
//
//	@Override
//	public List<Groups> getGroupsBycollegeId(int collegeId) {
//		// retrieve comments by postId
//
//        List<Groups> listOfgroups = groupsRepository.findById(collegeId);
//
// 
//
//        // convert list of comment entities to list of comment dto's
//        
//        return listOfgroups;
//
////        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
//	}
//
//	@Override
//	public Groups getGroupsById(int collegeId, int groupId) {
//		// retrieve post entity by id
//
//        College college = collegeRepository.findById(collegeId).orElseThrow(
//
//                () -> new ResourceNotFoundException("College", "code", collegeId));
//
// 
//
//        // retrieve comment by id
//
//        Groups groups = (Groups) groupsRepository.findById(groupId);
//        		/*.orElseThrow(() ->
//
//                new ResourceNotFoundException("Group", "id", groupId));*/
//
// 
//
//        if(groups.getCollege().getId() != (college.getId())){
//
//            throw new AppApiExceptions(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
//
//        }
//
// 
//
//        return groups;
//	}
//
//	@Override
//	public Groups updateGroup(int collegeId, int groupId, Groups groupRequest) {
//		College college = collegeRepository.findById(collegeId).orElseThrow(
//
//                () -> new ResourceNotFoundException("College", "code", collegeId));
//
// 
//
//        // retrieve comment by id
//
//		Groups groups = (Groups) groupsRepository.findById(groupId);
////				.orElseThrow(() ->
////
////        new ResourceNotFoundException("Group", "id", groupId));
//
// 
//
//		 if(groups.getCollege().getCollegeCode() != (college.getCollegeCode())){
//
//	            throw new AppApiExceptions(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
//
//	        }
//
// 
//
//		 groups.setGroupName(groupRequest.getGroupName());
//        
//
//		 groups.setGroupCode(groupRequest.getGroupCode());
//
//        groups.setCollege(groupRequest.getCollege());
//        groups.setNoOfSeates(groupRequest.getNoOfSeates());
// 
//
//        Groups updatedGroups = groupsRepository.save(groups);
//
//        return updatedGroups;
//	}
//
//	@Override
//	public void deleteGroup(int collegeId, int groupId) {
//		// retrieve post entity by id
//
//        College college = collegeRepository.findById(collegeId).orElseThrow(
//
//                () -> new ResourceNotFoundException("Post", "id", collegeId));
//
// 
//
//        // retrieve comment by id
//
//        Groups groups = (Groups) groupsRepository.findById(groupId);
//        		/*.orElseThrow(() ->
//
//        new ResourceNotFoundException("Group", "id", groupId));*/
//
// 
//
//		 if(groups.getCollege().getCollegeCode() != (college.getCollegeCode())){
//
//	            throw new AppApiExceptions(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
//
//	        }
//
//
// 
//
//       groupsRepository.delete(groups);
//		
//	}
//	
//	

	@Autowired
	private GroupsRepository groupsRepository;

	public Groups createGroup(Groups group) {
		Groups group1 = null;
		if (group.getGroupCode() != 0) {
			group1 = groupsRepository.save(group);
		}
		return group1;
	}

	public List<Groups> getAllGroupss() {

		return groupsRepository.findAll();
	}
	
	public Groups getById(int id) throws ResourceNotFoundException {
	    if (id != 0) {
	        Optional<Groups> groupsOptional = groupsRepository.findById(id);

	        if (groupsOptional.isPresent()) {
	            return groupsOptional.get(); // Groups with the specified ID exists, so return it
	        } else {
	            throw new ResourceNotFoundException("Groups not found with id: " + id +" it's not possible to read the values !!!!");
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid ID: " + id);
	    }
	}


	/*
	 * public Optional<Groups> getById(int id) { Optional<Groups> Groups1 = null; if
	 * (id != 0) { Groups1 = groupsRepository.findById(id); } return Groups1; }
	 */
	
	public Groups updateById(int id, Groups groups) throws ResourceNotFoundException {
	    Optional<Groups> groups1 = groupsRepository.findById(id);

	    if (groups1.isPresent()) {
	        Groups updatedGroups1 = groups1.get();
	        updatedGroups1.setGroupCode(groups.getGroupCode());
	        updatedGroups1.setGroupName(groups.getGroupName());

	        // Save the updated group
	        return groupsRepository.save(updatedGroups1);
	    } else {
	        throw new ResourceNotFoundException("Groups not found with id: " + id+" so it's not possible to update!!!");
	    }
	}


	/*
	 * public Groups updateById(int id, Groups Groups) { Groups ResGroups = null;
	 * Optional<Groups> Groups1 = groupsRepository.findById(id); if
	 * (Groups1.isPresent()) { Groups updatedGroups1 = Groups1.get();
	 * updatedGroups1.setGroupCode(Groups.getGroupCode());
	 * updatedGroups1.setGroupName(Groups.getGroupName());
	 * 
	 * ResGroups = groupsRepository.save(updatedGroups1); } return ResGroups; }
	 */

	/*
	 * public void deleteById(int id) {
	 * 
	 * if (id != 0) { groupsRepository.deleteById(id); } }
	 */
	public void deleteById(int id) throws ResourceNotFoundException {
	    if (id != 0) {
	        if (groupsRepository.existsById(id)) {
	            groupsRepository.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("Groups not found with id: " + id+" so we can't delete!!!!");
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid ID: " + id);
	    }
	}


}
