package com.counselling.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.College;
import com.counselling.entity.CounsellingResult;
import com.counselling.entity.Enroll;
import com.counselling.entity.Student;
import com.counselling.repository.CollegeRepository;
import com.counselling.repository.CounsellinResultRepository;
import com.counselling.repository.StudentRepository;
import com.counselling.repository.EnrollRepository;

@Service
public class CounsellingResultService {
	@Autowired
	private EnrollRepository enrollRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private StudentService studentService;

	@Autowired
	private EnrollService enrollService;

	@Autowired
	private CounsellinResultRepository counsellingResultRepository;

	@Autowired
	private CounsellingResult counsellingResult;

	@Autowired
	private College college;

	public CounsellingResult createResult(CounsellingResult counsellingResult, int enrollId) {
		CounsellingResult counsellingResult1 = null;
		counsellingResult1 = counsellingResultRepository.save(counsellingResult);
		return counsellingResult1;
	}

	public Optional<Enroll> getByEnrollId(int id) {
		Optional<Enroll> enrolledStudentDetails = null;
		if (enrollRepository.existsById(id)) {
			enrolledStudentDetails = enrollRepository.findById(id);
		} else {
			System.out.println("please check your enroll id");
		}
		return enrolledStudentDetails;
	}
	public CounsellingResult findCounsellingResult(int collegeCode, int studentId, int enrollId)
			throws ResourceNotFoundException {
		College college = collegeRepository.findById(collegeCode)
				.orElseThrow(() -> new ResourceNotFoundException("College  not found with " + " id : " + collegeCode));
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with " + "id " + studentId));
		Enroll enroll = enrollRepository.findById(enrollId)
				.orElseThrow(() -> new ResourceNotFoundException("Enrollement  not found with " + "id " + enrollId));

//		Enroll enroll = enrollRepository.findByEnrollIdCollegeCodeStudentId(enrollId,collegeCode,studentId).orElseThrow(()->new ResourceNotFoundException("Enroll  not found with "+ "id"+ enrollId));

		CounsellingResult councelResult = new CounsellingResult();
		if (collegeService.getMinMarks(enroll.getCollege().getCollegeCode()).getMinMarksReq() <= studentService
				.getMarks(enroll.getStudent().getStudentId()).getStudentMarks()) {

			counsellingResult.setEnroll(enrollService.getByEnrollIdd(enrollId));
			councelResult.setResult("Selected");
			councelResult.setEnroll(enroll);
			councelResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			councelResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			councelResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setEnroll(enroll);
			counsellingResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			counsellingResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			counsellingResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setResult("Congratulations!");
			counsellingResultRepository.save(councelResult);
		} else {
			councelResult.setResult("Not Selected");
			councelResult.setEnroll(enroll);
			councelResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			councelResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			councelResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setEnroll(enroll);
			counsellingResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			counsellingResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			counsellingResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setResult("we are sorry!");
			counsellingResultRepository.save(councelResult);
		}
		return counsellingResult;
	}
	public CounsellingResult getresultDeatils(int enrollId) throws ResourceNotFoundException {

		Enroll enroll = enrollRepository.findById(enrollId)
				.orElseThrow(() -> new ResourceNotFoundException("Enrollement  not found with " + "id " + enrollId));

		CounsellingResult councelResult = new CounsellingResult();

		if (collegeService.getMinMarks(enroll.getCollege().getCollegeCode()).getMinMarksReq() <= studentService
				.getMarks(enroll.getStudent().getStudentId()).getStudentMarks()) {
			counsellingResult.setEnroll(enrollService.getByEnrollIdd(enrollId));
			
			//to strore in db
			
			councelResult.setResult("Selected");
			councelResult.setEnroll(enroll);
			councelResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			councelResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			councelResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			
//			showing to student
			
			counsellingResult.setEnroll(enroll);
			counsellingResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			counsellingResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			counsellingResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setResult("Congratulations");
			if (counsellingResultRepository.existByEnrollId(enrollId)) {
			    CounsellingResult existingRecord = counsellingResultRepository.findByEnrollId(enrollId);
			    existingRecord.setResult("Selected");
			    counsellingResult.setResult("Congratulations");// Update other properties as needed
			    counsellingResultRepository.save(existingRecord);
			} else {
				
			    // If no record exists, save a new one
				councelResult.setResult("Selected");
			    counsellingResultRepository.save(councelResult);
			    counsellingResult.setResult("Congratulations");

			}

		} else {
			
		    //to strore in db
			
			councelResult.setResult("Not Selected");
			councelResult.setEnroll(enroll);
			councelResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			councelResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			councelResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setEnroll(enroll);
			counsellingResult.setSelectedCollegeName(enroll.getCollege().getCollegeName());
			counsellingResult.setEnrolledStudentName(enroll.getStudent().getStudentName());
			counsellingResult.setSelectedGroupName(enroll.getGroups().getGroupName());
			counsellingResult.setResult("we are sorry");
			
//			counsellingResultRepository.save(councelResult);
			
			if (counsellingResultRepository.existByEnrollId(enrollId)) {
				CounsellingResult existingRecord = counsellingResultRepository.findByEnrollId(enrollId);
			    existingRecord.setResult("Not Selected");
			    counsellingResult.setResult("we are sorry");
			    
			    // Update other properties as needed
			    counsellingResultRepository.save(existingRecord);	
				
			} else {
				
			    // If no record exists, save a new one
				
				councelResult.setResult("Not Selected");
			    counsellingResultRepository.save(councelResult);
			    counsellingResult.setResult("we are sorry");  
			}
		}
		return counsellingResult;
	}
	
}
