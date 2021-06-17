package org.aibless.backendjava.studentservice.repository;

import org.aibless.backendjava.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
