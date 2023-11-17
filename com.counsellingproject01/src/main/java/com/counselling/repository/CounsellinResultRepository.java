package com.counselling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.counselling.entity.CounsellingResult;

import feign.Param;


public interface CounsellinResultRepository extends JpaRepository<CounsellingResult, Integer> { 
	
	@Query(value="select * from counselling_result where student_id =:studentId",nativeQuery = true)
	public boolean existByStudentId(int studentId);
	
	
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CounsellingResult c WHERE c.enroll.enrollId = :enrollId")
	boolean existByEnrollId(@Param("enrollId") int enrollId);


	@Query(value="select * from counselling_result where enroll_id =:enrollId",nativeQuery = true)
	public CounsellingResult findByEnrollId(int enrollId);
	
	

}
