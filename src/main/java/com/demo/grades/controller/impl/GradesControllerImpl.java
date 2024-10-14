package com.demo.grades.controller.impl;

import com.demo.grades.controller.GradesController;
import com.demo.grades.response.StudentGradeResponse;
import com.demo.grades.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GradesControllerImpl implements GradesController {

    private final GradeService gradeService;

    @Override
    public ResponseEntity<StudentGradeResponse> getGrade(final String studentName) {
        final String grade = gradeService.getGradeForStudent(studentName);
        final StudentGradeResponse response = buildStudentGradeResponse(studentName, grade);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private StudentGradeResponse buildStudentGradeResponse(final String name, final String grade) {
        return StudentGradeResponse.builder()
            .name(name)
            .grade(grade)
            .build();
    }

}
