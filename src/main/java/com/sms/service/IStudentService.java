package com.sms.service;

import java.util.List;
import java.util.Optional;

import com.sms.model.Student;

public interface IStudentService {

	Integer saveStudent(Student student);

	public List<Student> getAllStudent();

	Optional<Student> getStudent(Integer id);

	public void deleteStudent(Integer id);

	public void deleteAllStudent();

	Student updateStudent(Student student, Integer id);

	List<Student> getStudentsByStandard(Integer standard);
}
