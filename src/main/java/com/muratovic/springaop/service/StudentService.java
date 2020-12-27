package com.muratovic.springaop.service;

import com.muratovic.springaop.domain.Student;

import javax.persistence.EntityNotFoundException;

public interface StudentService {

    Student find(Long studentId) throws EntityNotFoundException;

    Student create(Student student);


}
