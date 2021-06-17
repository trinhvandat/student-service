package org.aibless.backendjava.studentservice.service;

import org.aibless.backendjava.studentservice.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(int studentID, Student student);

    Student deleteStudent(int studentID);

    List<Student> listStudent();

}
