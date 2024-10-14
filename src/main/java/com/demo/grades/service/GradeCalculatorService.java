package com.demo.grades.service;

public interface GradeCalculatorService {

    /**
     * Calculates students grade based on provided score
     *
     * @param score student's score
     * @return student's grade
     */
    String calculateGrade(int score);

}
