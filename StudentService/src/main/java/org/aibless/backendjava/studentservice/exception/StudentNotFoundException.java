package org.aibless.backendjava.studentservice.exception;

import org.aibless.backendjava.studentservice.exception.common.StudentServiceError;
import org.aibless.backendjava.studentservice.exception.common.StudentServiceException;

public class StudentNotFoundException extends StudentServiceException {
    public StudentNotFoundException() {
        super(StudentServiceError.STUDENT_NOT_FOUND);
    }
}
