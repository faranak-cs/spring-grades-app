package com.demo.grades.controller;

import com.demo.grades.response.ErrorResponse;
import com.demo.grades.response.StudentGradeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Grades", description = "Operations on students' grades")
@RequestMapping("/grade")
public interface GradesController {


    @GetMapping("/{studentName}")
    @Operation(summary = "Get grade for given student",
        description = "Calculates grade for given student based on student's final score",
        method = "GET",
        responses = {
            @ApiResponse(responseCode = "200",
                description = "Student found and grade calculated",
                content = @Content(schema = @Schema(implementation = StudentGradeResponse.class))
            ),
            @ApiResponse(responseCode = "404",
                description = "Student not found",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
        })
    ResponseEntity<StudentGradeResponse> getGrade(@PathVariable String studentName);

}
