package org.aibless.backendjava.studentservice.service.iml;

import org.aibless.backendjava.studentservice.dto.StudentDTO;
import org.aibless.backendjava.studentservice.model.Student;
import org.aibless.backendjava.studentservice.repository.StudentRepository;
import org.aibless.backendjava.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIml implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public  StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentRepository.save(student));
    }

    public Student getByID(int Id) {
        return studentRepository.findById(Id);
    }
    @Override
    public StudentDTO updateStudent(int studentID, StudentDTO studentDTO) {
        Student studentReq = convertToEntity(studentDTO);
        Student student = getByID(studentID);
        student.setName(studentReq.getName());
        student.setCode(studentReq.getCode());
        student.setAddress(studentReq.getAddress());
        student.setDob(studentReq.getDob());
        return convertToDTO(studentRepository.save(student));
    }

    @Override
    public Student deleteStudent(int studentID) {
        Student student = getByID(studentID);
        studentRepository.delete(student);
        return student;
    }

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDTO getById(int id) {
        Student student = studentRepository.getById(id);
        return convertToDTO(student);
    }

    @Override
    public List<StudentDTO> getByName(String c) {
        List<Student> studentList = studentRepository.findByName(c);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student s:studentList) {
            studentDTOList.add(convertToDTO(s));
        }
        return studentDTOList;
    }

    @Override
    public StudentDTO getByCode(String code) {
        Student student = studentRepository.findByCode(code);
        return  convertToDTO(student);
    }

    @Override
    public List<StudentDTO> getByAddress(String address) {
        List<Student> studentList = studentRepository.findByAddress(address);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student s:studentList) {
            studentDTOList.add(convertToDTO(s));
        }
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> getByDob(Date date) {
        List<Student> studentList = studentRepository.findByDob(date);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student s:studentList) {
            studentDTOList.add(convertToDTO(s));
        }
        return studentDTOList;
    }

    private  Student convertToEntity(StudentDTO studentDTO){
        Student student = new Student();
        //student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setCode(studentDTO.getCode());
        student.setAddress(studentDTO.getAddress());
        student.setDob(studentDTO.getDob());
        return  student;
    }

    private  StudentDTO convertToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setCode(student.getCode());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setDob(student.getDob());
        return  studentDTO;
    }
}
