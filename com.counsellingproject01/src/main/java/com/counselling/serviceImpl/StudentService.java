package com.counselling.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.counselling.Exceptions.ResourceNotFoundException;
import com.counselling.entity.Student;
import com.counselling.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

//	@Autowired
//	private Student student;
	public Student createStudent(Student student) {
		Student student1 = null;
		if (student.getStudentId() != 0) {
			student1 = studentRepository.save(student);
		}

		return student1;
	}

	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	/*
	 * public Optional<Student> getById(int id) { Optional<Student> student1 = null;
	 * if (id != 0) { student1 = studentRepository.findById(id); } return student1;
	 * }
	 */
	public Student getById(int id) throws ResourceNotFoundException {
	    if (id != 0) {
	        Optional<Student> studentOptional = studentRepository.findById(id);

	        if (studentOptional.isPresent()) {
	            return studentOptional.get(); // Return the Student if it exists
	        } else {
	            throw new ResourceNotFoundException("Student not found with id: " + id);
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid ID: " + id);
	    }
	}

	/*
	 * public Student updateById(int id, Student student) { Student ResStudent =
	 * null; Optional<Student> student1 = studentRepository.findById(id); if
	 * (student1.isPresent()) { Student updatedStudent1 = student1.get();
	 * updatedStudent1.setStudentId(student.getStudentId());
	 * updatedStudent1.setStudentName(student.getStudentName());
	 * updatedStudent1.setStudentMarks(student.getStudentMarks());
	 * updatedStudent1.setStudentUgGroup(student.getStudentUgGroup()); ResStudent =
	 * studentRepository.save(updatedStudent1); } return ResStudent; }
	 */
	
	public Student updateById(int id, Student student) throws ResourceNotFoundException {
	    Optional<Student> studentOptional = studentRepository.findById(id);

	    if (studentOptional.isPresent()) {
	        Student updatedStudent = studentOptional.get();
	        updatedStudent.setStudentName(student.getStudentName());
	        updatedStudent.setStudentMarks(student.getStudentMarks());
	        updatedStudent.setStudentUgGroup(student.getStudentUgGroup());

	        // Save the updated student
	        return studentRepository.save(updatedStudent);
	    } else {
	        throw new ResourceNotFoundException("Student not found with id: " + id);
	    }
	}


	/*
	 * public void deleteStudentById(int id) {
	 * 
	 * if (id != 0) { studentRepository.deleteById(id); } }
	 */
	public void deleteStudentById(int id) throws ResourceNotFoundException {
	    if (id != 0) {
	        if (studentRepository.existsById(id)) {
	            studentRepository.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("Student not found with id: " + id);
	        }
	    } else {
	        throw new IllegalArgumentException("Invalid ID: " + id);
	    }
	}

	public Student getMarks(int studentId) {
		Student student = null;
		return studentRepository.findByStudentId(studentId);
//		Optional<Student> optional =studentRepository.findById(studentId);
//		if (optional.isPresent()) {
//			student = optional.get();
//			
//		}
//		return student;
	}

}
