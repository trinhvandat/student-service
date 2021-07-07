package org.aibless.backendjava.studentservice.service;

import org.aibless.backendjava.studentservice.dto.StudentDTO;
import org.aibless.backendjava.studentservice.model.Student;

import java.sql.Date;
import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(int studentID, StudentDTO studentDTO);

    Student deleteStudent(int studentID);

    List<Student> listStudent();

    StudentDTO getById( int id);

    List<StudentDTO> getByName(String c);

    StudentDTO getByCode(String code);

    List<StudentDTO> getByAddress(String address);

    List<StudentDTO> getByDob(Date date);

}
