package org.aibless.backendjava.studentservice.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class StudentDTO {

    private Integer id;

    private String name;

    private String code;

    private String address;

    private Date dob;
}
