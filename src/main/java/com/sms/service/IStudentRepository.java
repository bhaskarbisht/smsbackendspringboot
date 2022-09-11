package com.sms.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
