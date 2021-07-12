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

    StudentDTO getStudentById( int id);

    List<StudentDTO> getStudentByName(String c);

    StudentDTO getStudentByCode(String code);

    List<StudentDTO> getStudentByAddress(String address);

    List<StudentDTO> getStudentByDob(Date date);

}
