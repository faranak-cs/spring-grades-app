package com.demo.grades.service.impl;

import com.demo.grades.exception.StudentNotFoundException;
import com.demo.grades.repository.StudentScoreFakeRepository;
import com.demo.grades.service.GradeCalculatorService;
import com.demo.grades.service.GradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class GradeServiceImplTest {

    @Mock
    private StudentScoreFakeRepository studentScoreFakeRepositoryMock;

    @Mock
    private GradeCalculatorService gradeCalculatorServiceMock;

    private GradeService cut;

    @BeforeEach
    void setUp() {
        cut = new GradeServiceImpl(studentScoreFakeRepositoryMock, gradeCalculatorServiceMock);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(studentScoreFakeRepositoryMock, gradeCalculatorServiceMock);
    }

    @Test
    void givenStudentNameThatExists_whenGetGrade_thenReturnGrade() {
        // Setup
        final String studentName = "rick";
        final int score = 99;
        when(studentScoreFakeRepositoryMock.getStudentScore(studentName)).thenReturn(Optional.of(score));

        final String grade = "H1";
        when(gradeCalculatorServiceMock.calculateGrade(score)).thenReturn(grade);

        // Execute
        final String actualGrade = cut.getGradeForStudent(studentName);

        // Verify
        assertThat(actualGrade).isEqualTo(grade);

        verify(studentScoreFakeRepositoryMock).getStudentScore(studentName);
        verify(gradeCalculatorServiceMock).calculateGrade(score);
    }

    @Test
    void givenStudentNameThatDoesNotExist_whenGetGrade_thenThrowStudentNotFoundException() {
        // Setup
        final String studentName = "rick";
        when(studentScoreFakeRepositoryMock.getStudentScore(studentName)).thenReturn(Optional.empty());

        // Execute & verify
        assertThatThrownBy(() -> cut.getGradeForStudent(studentName))
            .isInstanceOf(StudentNotFoundException.class)
            .hasMessageContaining("Student rick not found");

        verify(studentScoreFakeRepositoryMock).getStudentScore(studentName);
    }

}
