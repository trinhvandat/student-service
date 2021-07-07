package org.aibless.backendjava.studentservice.repository;

import org.aibless.backendjava.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int id);

    List<Student> findByAddress(String ad);

    Student findByCode(String code);

    List<Student> findByName(String c);

    List<Student> findByDob(Date date);
}
