package com.example.swagger.controller;

import com.example.swagger.errors.ErrorMessage;
import com.example.swagger.errors.GlobalExceptionHandler;
import com.example.swagger.model.Student;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    @ApiOperation(value = "Get Students",
            notes = "Get all students")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "Student created"),
            @ApiResponse(code = 400, message = "Bad Request", response = GlobalExceptionHandler.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorMessage.class),
            @ApiResponse(code = 422, message = "Unprocessable entity", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)})
    @GetMapping("/student")
    public ResponseEntity<List<Student>> wishStudent(){
        List<Student> students = Arrays.asList(Student.builder().id("1").name("atul").build(),
                Student.builder().id("2").name("Ramesh").build(),
                Student.builder().id("3").name("Shivam").build());
        System.out.println(students);
        return ResponseEntity.ok().body(students);
    }
}
