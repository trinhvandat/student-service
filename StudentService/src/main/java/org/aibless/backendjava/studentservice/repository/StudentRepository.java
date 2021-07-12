package org.aibless.backendjava.studentservice.repository;

import org.aibless.backendjava.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findById(int id);

    List<Student> findByAddress(String ad);

    Optional<Student> findByCode(String code);

    List<Student> findByName(String c);

    List<Student> findByDob(Date date);
}
