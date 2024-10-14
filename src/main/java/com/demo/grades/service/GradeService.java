package com.demo.grades.service;

public interface GradeService {

    /**
     * Retrieves grade for given student
     *
     * @param studentName student's name
     * @return student's grade
     */
    String getGradeForStudent(String studentName);

}
