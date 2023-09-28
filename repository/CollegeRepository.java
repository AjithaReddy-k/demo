package com.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegemanagementsystem.entity.CollegeEntity;
@Repository

public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer> {

}
