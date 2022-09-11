package com.sms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.exception.ResourceNotFoundException;
import com.sms.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentrepo;

	@Override
	public Integer saveStudent(Student student) {
		Student savedStudent = studentrepo.save(student);

		return savedStudent.getId();
	}

	@Override
	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}

//	@Override
//	public Student getStudent(Integer id) {
//		Optional<Student> optstudent = studentrepo.findById(id);
//		if (optstudent.isPresent()) {
//			return optstudent.get();
//		} else {
//			throw new ResourceNotFoundException("Student", "id", id);
//		}
//	}

	
	@Override
	public Optional<Student> getStudent(Integer id){
		
		return studentrepo.findById(id);
		
	}
	
	@Override
	public void deleteStudent(Integer id) {
		studentrepo.deleteById(id);
	}

	@Override
	public void deleteAllStudent() {
		studentrepo.deleteAll();
	}

	@Override
	public Student updateStudent(Student student, Integer id) {

		Student existingStudent = studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setStandard(student.getStandard());
		existingStudent.setDob(student.getDob());
		existingStudent.setSubject(student.getSubject());

		studentrepo.save(existingStudent);
		return existingStudent;
	}

	@Override
	public List<Student> getStudentsByStandard(Integer standard) {

		List<Student> list = studentrepo.findAll();
		return list.stream().filter(student -> student.getStandard() == standard).collect(Collectors.toList());

	}

}
