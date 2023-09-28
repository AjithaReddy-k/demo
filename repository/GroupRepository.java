package com.collegemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagementsystem.entity.Groups;

public interface GroupRepository extends JpaRepository<Groups, Integer> {

}
