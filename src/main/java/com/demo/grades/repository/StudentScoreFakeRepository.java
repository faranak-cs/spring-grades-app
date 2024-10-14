package com.demo.grades.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

/**
 * Simulates repository class
 */
@Repository
public class StudentScoreFakeRepository {

    /**
     * Simulates database table
     */
    private static final Map<String, Integer> studentScores = Map.of(
        "rick", 99,
        "morty", 39
    );

    /**
     * Retrieves score for given student
     *
     * @param studentName student's name
     * @return Optional of student's score or empty Optional if student could not be found
     */
    public Optional<Integer> getStudentScore(final String studentName) {
        final Integer score = studentScores.get(studentName.toLowerCase());

        return Optional.ofNullable(score);
    }

}
