package org.aibless.backendjava.studentservice.service.iml;

import org.aibless.backendjava.studentservice.model.Student;
import org.aibless.backendjava.studentservice.repository.StudentRepository;
import org.aibless.backendjava.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIml implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public  StudentServiceIml(StudentRepository studentRepository) {this.studentRepository = studentRepository;}


    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int studentID, Student studentReq) {
        return studentRepository.findById(studentID)
                .map(student -> {
                    student.setName(studentReq.getName());
                    student.setCode(studentReq.getCode());
                    student.setAddress(studentReq.getAddress());
                    student.setDob(studentReq.getDob());
                    return  student;
                })
                .map(studentRepository::save)
                .orElse(null);
    }

    @Override
    public Student deleteStudent(int studentID) {
        return  studentRepository.findById(studentID)
                .map(student -> {
                    studentRepository.delete(student);
                    return student;
                })
                .orElse(null);
    }

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }
}
