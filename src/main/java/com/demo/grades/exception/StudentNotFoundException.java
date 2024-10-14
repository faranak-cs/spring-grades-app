package com.demo.grades.exception;

public class StudentNotFoundException extends RuntimeException {

    private static final String STUDENT_NOT_FOUND_MESSAGE = "Student %s not found";

    /**
     * Exception to be thrown when student with given name could not be found
     *
     * @param studentName student's name
     */
    public StudentNotFoundException(final String studentName) {
        super(String.format(STUDENT_NOT_FOUND_MESSAGE, studentName));
    }

}
