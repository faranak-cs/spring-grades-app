package com.demo.grades.service.impl;

import com.demo.grades.exception.StudentNotFoundException;
import com.demo.grades.repository.StudentScoreFakeRepository;
import com.demo.grades.service.GradeCalculatorService;
import com.demo.grades.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final StudentScoreFakeRepository studentScoreFakeRepository;

    private final GradeCalculatorService gradeCalculatorService;

    @Override
    public String getGradeForStudent(final String studentName) {
        final int studentScore = studentScoreFakeRepository.getStudentScore(studentName)
            .orElseThrow(() -> new StudentNotFoundException(studentName));

        return gradeCalculatorService.calculateGrade(studentScore);
    }

}
