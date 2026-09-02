package com.badri.codexon.common.exception;

import com.badri.codexon.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProblemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProblemNotFound(ProblemNotFoundException ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(DuplicateProblemException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateProblem(DuplicateProblemException ex,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request){
        String message=ex.getFieldErrors()
                .stream()
                .map(
                       error->error.getField()+" : "+
                       error.getDefaultMessage()
                )
                .collect(Collectors.joining(", \n"));

        ErrorResponse response=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                message,
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(ExampleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleExampleNotFound(ExampleNotFoundException ex,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                404,
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(EditorialNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEditorialNotFound(EditorialNotFoundException ex,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                404,
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(404)
                .body(response);
    }

    @ExceptionHandler(ProblemTagNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProblemTagNotFound(ProblemNotFoundException ex,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                404,
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return  ResponseEntity.status(404)
                .body(response);
    }

    @ExceptionHandler(TagNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTagNotFound(TagNotFoundException ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                404,
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(404)
                .body(response);
    }

    @ExceptionHandler(TestCaseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTestCaseNotFound(TestCaseNotFoundException ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                404,
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(404)
                .body(response);
    }

    @ExceptionHandler(InvalidSortFieldException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSortField(InvalidSortFieldException ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(400)
                .body(response);
    }

    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                "The requested operation violates a data constraints",
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(409)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                500,
                "INTERNAL_SERVER_ERROR",
                "An Unexpected error occurred",
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

}
