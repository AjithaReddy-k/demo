package com.counselling.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counselling.dto.EnrollDto;
import com.counselling.entity.College;
import com.counselling.entity.Enroll;
import com.counselling.entity.Groups;
import com.counselling.entity.Student;
import com.counselling.repository.CollegeRepository;
import com.counselling.repository.EnrollRepository;
import com.counselling.repository.StudentRepository;

@Service
public class EnrollService  {
     ModelMapper mapper=new ModelMapper();
	@Autowired
	private EnrollRepository enrollRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
//	@Autowired
//	private GroupsRepository geGroupsRepository;

public Enroll createEnrollement(Enroll enroll) {
		return enrollRepository.save(enroll);
	}

	/*
	 * public EnrollDto createEnroll(EnrollDto enrollDto) { Enroll enroll1 =
	 * mapToEntity(enrollDto); Enroll newUser = enrollRepository.save(enroll1); //
	 * convert entity to DTO EnrollDto userResponse = mapToDTO(newUser); return
	 * userResponse;
	 * 
	 * 
	 * // return userRepository.save(user); } private EnrollDto mapToDTO(Enroll
	 * enroll) { EnrollDto userDto = mapper.map(enroll, EnrollDto.class); return
	 * userDto; } // convert DTO to entity private Enroll mapToEntity(EnrollDto
	 * enrollDto){
	 * 
	 * Enroll user = mapper.map(enrollDto, Enroll.class); return user; }
	 */
	public Optional<Enroll> getByEnrollId(int id) {
		Optional<Enroll> enrolledStudentDetails = null;
		if (enrollRepository.existsById(id) ) {
			enrolledStudentDetails = enrollRepository.findById(id);
			
		}else {
			System.out.println("please check your enroll id");
		}
		return enrolledStudentDetails;
	}
	public Enroll getByEnrollIdd(int enrollId) {
		return enrollRepository.findByEnrollId(enrollId);
//		return enrollRepository.findByStudentId(studentId);	
	}
	public Enroll createEnroll( int enrollId ,int collegeCode, int studentId, int groupCode) {
		
		Enroll enroll = new Enroll();

	    // Set the properties for the Enroll object
	    College college = new College();
	    college.setCollegeCode(collegeCode);

	    Student student = new Student();
	    student.setStudentId(studentId);

	    Groups groups = new Groups();
	    groups.setGroupCode(groupCode);

	    // Set the relationships
	    enroll.setCollege(college);
	    enroll.setStudent(student);
	    enroll.setGroups(groups);
	    enroll.setEnrollId(enrollId);

	    // You can set other properties of the Enroll object as needed

	    return enrollRepository.save(enroll);
	}
	

}
