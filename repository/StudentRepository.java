package com.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegemanagementsystem.entity.StudentEntity;
@Repository

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
