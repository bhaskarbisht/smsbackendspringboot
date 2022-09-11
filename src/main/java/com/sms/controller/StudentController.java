package com.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Student;
import com.sms.service.IStudentService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	IStudentService studentService;


	@PostMapping("/createStudent")
	Integer createStudent(@RequestBody Student student) {
		Integer id = studentService.saveStudent(student);
		return id;
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();

	}

	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id) {
		Optional<Student> student = studentService.getStudent(id);
		return student;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@DeleteMapping("/deleteall")
	public void deleteAllStudent() {

		studentService.deleteAllStudent();

	}
	
	@GetMapping("standard/{classid}")
	public List<Student> studentsByStandard(@PathVariable("classid") Integer standard) {
		return  studentService.getStudentsByStandard(standard);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){
	return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);	
	}
}
