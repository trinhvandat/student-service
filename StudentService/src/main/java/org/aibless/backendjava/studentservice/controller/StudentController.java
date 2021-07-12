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
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        final  StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return  new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{student_id}")
    public  ResponseEntity<StudentDTO> updateStudent(@PathVariable("student_id") int studentId,
                                                     @RequestBody StudentDTO studentDTO) {
        final StudentDTO updatedStudent = studentService.updateStudent(studentId, studentDTO);
        return  new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("student_id") int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<Student>> listStudents() {
        final List<Student> students = studentService.listStudent();
        return  new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable ("id") int id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return  new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    public  ResponseEntity<List<StudentDTO>> getStudentByName(@RequestParam("name") String name) {
        List<StudentDTO> studentDTOList = studentService.getStudentByName(name);
        return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @GetMapping(params = {"code"})
    public ResponseEntity<StudentDTO> getStudentByCode(@RequestParam("code") String code) {
        StudentDTO studentDTO = studentService.getStudentByCode(code);
        return  new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @GetMapping(params = "address")
    public  ResponseEntity<List<StudentDTO>> getStudentByAddress(@RequestParam("address") String address) {
        final List<StudentDTO> studentDTOList =studentService.getStudentByAddress(address);
        return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @GetMapping(params = "dob")
    public ResponseEntity<List<StudentDTO>> getStudentByDob(@RequestParam("dob") Date dob) {
        final List<StudentDTO> studentDTOList = studentService.getStudentByDob(dob);
        return  new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }
 }
