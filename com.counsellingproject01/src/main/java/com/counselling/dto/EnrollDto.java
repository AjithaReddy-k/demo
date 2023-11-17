package com.counselling.dto;

public class EnrollDto {
	private int enrollId;
	private int enrollStudentId;
	private int enrollCollegeCode;
	private int enrollGroupCode;
	
	public EnrollDto(int enrollStudentId,int enrollCollegeCode,int enrollGroupCode,int enrollId) {
		this.enrollCollegeCode=enrollCollegeCode;
		this.enrollGroupCode=enrollGroupCode;
		this.enrollStudentId=enrollStudentId;
		
	}
	public EnrollDto() {
		this.enrollCollegeCode=enrollCollegeCode;
		this.enrollGroupCode=enrollGroupCode;
		this.enrollStudentId=enrollStudentId;
		
	}

	public int getEnrollStudentId() {
		return enrollStudentId;
	}

	public int getEnrollCollegeCode() {
		return enrollCollegeCode;
	}

	public int getEnrollGroupCode() {
		return enrollGroupCode;
	}
	
}
