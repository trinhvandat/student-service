package org.aibless.backendjava.studentservice.controller;

import org.aibless.backendjava.studentservice.model.Student;
import org.aibless.backendjava.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private  final StudentService studentService;

    @Autowired
    public  StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        final  Student createdStudent = studentService.createStudent(student);
        return  new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{student_id}")
    public  ResponseEntity<Student> updateStudent(@PathVariable("student_id") int studentID, @RequestBody Student student) {
        final Student updatedStudent = studentService.updateStudent(studentID, student);
        if (updatedStudent == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("student_id") int studentID) {
        final Student deletedStudent = studentService.deleteStudent(studentID);
        if (deletedStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public  ResponseEntity<List<Student>> listStudent() {
        final List<Student> students = studentService.listStudent();
        return  new ResponseEntity<>(students, HttpStatus.OK);
    }
 }
