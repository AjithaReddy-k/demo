package com.collegemanagementsystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString
@Table(name="groupdetails")


public class Groups {
	@Id
	private int groupId;
	private String groupName;
	@ManyToOne
    @JoinColumn(name = "college_id")
    private CollegeEntity college;

	

}
