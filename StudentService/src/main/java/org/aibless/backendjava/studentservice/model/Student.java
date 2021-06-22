package org.aibless.backendjava.studentservice.model;

import com.fasterxml.jackson.databind.util.ClassUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "code")
    private  String code;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private Date dob;

    public Student() {
    }

    public Student(int id, String name, String code, String address, Date dob) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public  static Student setValues (Student student, Student studentReq) {
        student.setName(studentReq.getName());
        student.setCode(studentReq.getCode());
        student.setAddress(studentReq.getAddress());
        student.setDob(studentReq.getDob());
        return  student;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(!(obj instanceof  Student))  return  false;
        Student student = (Student) obj;
        return getId() == student.getId();
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
