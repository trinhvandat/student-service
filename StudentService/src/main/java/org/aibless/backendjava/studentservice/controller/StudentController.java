package org.aibless.backendjava.studentservice.controller;

import org.aibless.backendjava.studentservice.dto.StudentDTO;
import org.aibless.backendjava.studentservice.model.Student;
import org.aibless.backendjava.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private  final StudentService studentService;

    @Autowired
    public  StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        final  StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return  new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{student_id}")
    public  ResponseEntity<StudentDTO> updateStudent(@PathVariable("student_id") int studentId, @RequestBody StudentDTO studentDTO) {
        final StudentDTO updatedStudent = studentService.updateStudent(studentId, studentDTO);
        if (updatedStudent == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("student_id") int studentId) {
        final Student deletedStudent = studentService.deleteStudent(studentId);
        if (deletedStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public  ResponseEntity<List<Student>> listStudents() {
        final List<Student> students = studentService.listStudent();
        return  new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") int id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        if(studentDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(studentDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<?> getByName(@PathVariable("name") String character) {
        List<StudentDTO> studentDTOList = studentService.getStudentByName(character);
        if(studentDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
        }
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<?> getByCode(@PathVariable("code") String code) {
        StudentDTO studentDTO = studentService.getStudentByCode(code);
        if(studentDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(studentDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/address/{address}")
    public  ResponseEntity<?> getByAddress(@PathVariable("address") String address) {
        final List<StudentDTO> studentDTOList =studentService.getStudentByAddress(address);
        if(studentDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
        }
    }

    @GetMapping("/dob/{dob}")
    public ResponseEntity<?> getByDob(@PathVariable("dob") Date date) {
        final List<StudentDTO> studentDTOList = studentService.getStudentByDob(date);
        if(studentDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
        }
    }
 }
