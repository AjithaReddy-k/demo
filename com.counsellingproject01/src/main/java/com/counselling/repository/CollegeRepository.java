package com.counselling.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.counselling.entity.College;
import com.counselling.entity.Enroll;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
	
	public Optional<College>  findByCollegeCode(int collegeCode);
//	public Enroll findByCollegeCode(int collegeCode);
	
	
	@Query(value = "delete from college where college_code =:collegeCode",nativeQuery = true)
	public void deleteByCollegeCode(int collegeCode);
}
