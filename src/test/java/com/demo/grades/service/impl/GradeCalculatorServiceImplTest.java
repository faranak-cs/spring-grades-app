package com.demo.grades.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GradeCalculatorServiceImplTest {

    private GradeCalculatorServiceImpl cut;

    @BeforeEach
    void setUp() {
        cut = new GradeCalculatorServiceImpl();
    }

//    @Disabled
//    @Test
//    void givenScore70_whenCalculateGrade_thenReturnH1() {
//        // Setup
//        final int score = 70;
//
//        // Execute
//        final String actualGrade = cut.calculateGrade(score);
//
//        // Verify
//        assertThat(actualGrade).isEqualTo("First Class Hons (H1)");
//    }
//
//    @Test
//    void givenScore60_whenCalculateGrade_thenReturnH21() {
//        // Setup
//        final int score = 60;
//
//        // Execute
//        final String actualGrade = cut.calculateGrade(score);
//
//        // Verify
//        assertThat(actualGrade).isEqualTo("Second Class Hons Grade 1 (H2.1)");
//    }
//
//    @Test
//    void givenScore50_whenCalculateGrade_thenReturnH22() {
//        // Setup
//        final int score = 50;
//
//        // Execute
//        final String actualGrade = cut.calculateGrade(score);
//
//        // Verify
//        assertThat(actualGrade).isEqualTo("Second Class Hons Grade 2 (H2.2)");
//    }
//
//    @Test
//    void givenScore40_whenCalculateGrade_thenReturnPS() {
//        // Setup
//        final int score = 40;
//
//        // Execute
//        final String actualGrade = cut.calculateGrade(score);
//
//        // Verify
//        assertThat(actualGrade).isEqualTo("Pass (PS)");
//    }
//
//    @Test
//    void givenScore10_whenCalculateGrade_thenReturnFail() {
//        // Setup
//        final int score = 10;
//
//        // Execute
//        final String actualGrade = cut.calculateGrade(score);
//
//        // Verify
//        assertThat(actualGrade).isEqualTo("Fail");
//    }

    @ParameterizedTest
    @MethodSource("provideValuesForCalculateGrade")
    void testCalculateGrade(final int score, final String expectedGrade) {
        // Execute
        final String actualGrade = cut.calculateGrade(score);

        // Verify
        assertThat(actualGrade).isEqualTo(expectedGrade);
    }

    private static Stream<Arguments> provideValuesForCalculateGrade() {
        return Stream.of(
            Arguments.of(70, "First Class Hons (H1)"),
            Arguments.of(60, "Second Class Hons Grade 1 (H2.1)"),
            Arguments.of(50, "Second Class Hons Grade 2 (H2.2)"),
            Arguments.of(40, "Pass (PS)"),
            Arguments.of(10, "Fail")
        );
    }

}
