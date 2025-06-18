package team.sakak.codingtest.config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import team.sakak.codingtest.dto.ErrorRes;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorRes> handleIllegalArgument(
            IllegalArgumentException ex, HttpServletRequest request) {

        ErrorRes response = ErrorRes.of(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                "INVALID_ARGUMENT",
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorRes> handleEntityNotFound(
            EntityNotFoundException ex, HttpServletRequest request) {

        ErrorRes response = ErrorRes.of(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                "NOT_FOUND",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}