package com.counselling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.counselling.entity.College;
import com.counselling.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findByStudentId(int studentId);
}
