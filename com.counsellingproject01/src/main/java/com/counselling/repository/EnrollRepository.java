package com.counselling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.counselling.entity.College;
import com.counselling.entity.Enroll;
import com.counselling.entity.Student;
@Repository
public interface EnrollRepository extends JpaRepository<Enroll, Integer> {
	
	@Query(value="select * from enroll where enroll_id=:enrollId and college_code=:collegeCode and student_id=:studentId",nativeQuery = true)
	public Optional<Enroll> findByEnrollIdCollegeCodeStudentId(int enrollId, int collegeCode,int studentId);
	
    public Enroll findByEnrollId(int enrollId);
    
    @Query(value="select * from enroll where college_code =:collegeCode",nativeQuery = true)
     public Enroll findByCollegeCode(int collegeCode);
    
    
    
    @Query(value="select * from enroll where student_id =:studentId",nativeQuery = true)
	public Enroll findByStudentId(int studentId);
    
    @Query(value="select * from enroll where college_name =:collegeName",nativeQuery = true)
    public Enroll findByCollegeName( String collegeName);

//    @Query(value="select * from enroll where student_id =:studentId and  college_code =:collegeCode",nativeQuery = true)
//    public boolean findByStudentIdCollegeCode(int studentId,int collegeCode);
}
