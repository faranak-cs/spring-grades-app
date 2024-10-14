package com.demo.grades.service.impl;

import com.demo.grades.service.GradeCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class GradeCalculatorServiceImpl implements GradeCalculatorService {

    @Override
    public String calculateGrade(final int score) {
        final String grade;

        if (score >= 70) {
            grade = "First Class Hons (H1)";
        } else if (score >= 60) {
            grade = "Second Class Hons Grade 1 (H2.1)";
        } else if (score >= 50) {
            grade = "Second Class Hons Grade 2 (H2.2)";
        } else if (score >= 40) {
            grade = "Pass (PS)";
        } else {
            grade = "Fail";
        }

        return grade;
    }

}
