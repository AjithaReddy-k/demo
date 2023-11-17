package com.counselling.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.College;
import com.counselling.entity.Enroll;
import com.counselling.repository.CollegeRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository CollegeRepository;

	@Autowired
	private College College;
	public College createCollege(College college) {
		College College1 = null;
		if (college.getCollegeCode() != 0) {
			College1 = CollegeRepository.save(college);
		}

		return College1;
	}

	public List<College> getAllColleges() {

		return CollegeRepository.findAll();
	}
	public College getById(int id) throws ResourceNotFoundException {
	    if (id != 0) {
	        Optional<College> college = CollegeRepository.findById(id);

	        if (college.isPresent()) {
	            return college.get(); // College with the specified ID exists, so return it
	        } else {
	            throw new ResourceNotFoundException("College not found with id: " + id+" it's not possible to read the values!!!!");
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid ID: " + id);
	    }
	}


	/*
	 * public Optional<College> getById(int id) { Optional<College> College1 = null;
	 * if (id != 0) { College1 = CollegeRepository.findById(id); } return College1;
	 * }
	 */
	public College updateById(int id, College College) throws ResourceNotFoundException {
	    Optional<College> College1 = CollegeRepository.findById(id);

	    if (College1.isPresent()) {
	        College updatedCollege1 = College1.get();
	        updatedCollege1.setCollegeCode(College.getCollegeCode());
	        updatedCollege1.setCollegeName(College.getCollegeName());

	        // Save the updated college
	        return CollegeRepository.save(updatedCollege1);
	    } else {
	        throw new ResourceNotFoundException("College not found with id: " + id+" so we can't update!!!");
	    }
	}


	/*
	 * public College updateById(int id, College College) { College ResCollege =
	 * null; Optional<College> College1 = CollegeRepository.findById(id); if
	 * (College1.isPresent()) { College updatedCollege1 = College1.get();
	 * updatedCollege1.setCollegeCode(College.getCollegeCode());
	 * updatedCollege1.setCollegeName(College.getCollegeName()); //
	 * updatedCollege1.setGroupNumber(College.getGroupNumber()); ResCollege =
	 * CollegeRepository.save(updatedCollege1); } return ResCollege; }
	 */
	public void deleteById(int id) throws ResourceNotFoundException { 
//		boolean college = CollegeRepository.ex(id).orElseThrow(()-> new ResourceNotFoundException("College  not found with "+ " id : "+ id)) != null;
		/*
		 * if (CollegeRepository.existsById(id)) {
		 * CollegeRepository.deleteByCollegeCode(id); }else { new
		 * ResourceNotFoundException("college", "id", id); }
		 */
		 College college = CollegeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id+" it's not possible to delete!!!"));

		    // If the college exists, proceed with deletion
		    CollegeRepository.delete(college);
	}
	
	public College getMinMarks(int collegeCode) throws ResourceNotFoundException {
		return CollegeRepository.findByCollegeCode(collegeCode).orElseThrow(() -> new ResourceNotFoundException("college", "id", collegeCode));
	}

}
