package com.muratovic.springaop.repository;

import com.muratovic.springaop.domain.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Long>, JpaSpecificationExecutor<Student> {
}
