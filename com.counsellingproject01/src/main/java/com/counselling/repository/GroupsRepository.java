package com.counselling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.counselling.entity.Groups;

@Repository
public interface GroupsRepository extends JpaRepository<Groups , Integer> {
//	List<Groups> findById(int groupId);

}
