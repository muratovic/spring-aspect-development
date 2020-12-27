package com.muratovic.springaop.service;

import com.muratovic.springaop.domain.Student;
import com.muratovic.springaop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student find(Long studentId) throws EntityNotFoundException {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }
}
