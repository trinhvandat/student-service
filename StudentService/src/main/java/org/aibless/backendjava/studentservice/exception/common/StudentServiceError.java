package org.aibless.backendjava.studentservice.exception.common;

public enum StudentServiceError {
    STUDENT_NOT_FOUND(404, "Student not found");

    private final int errorCode;
    private final String errorMessage;

    private StudentServiceError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage =errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
