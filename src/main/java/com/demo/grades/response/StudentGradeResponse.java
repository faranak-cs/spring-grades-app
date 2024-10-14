package com.demo.grades.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class StudentGradeResponse {

    @Schema(description = "Student's name")
    String name;

    @Schema(description = "Student's grade")
    String grade;

}
