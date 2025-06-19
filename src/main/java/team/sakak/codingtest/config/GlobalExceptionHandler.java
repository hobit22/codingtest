package team.sakak.codingtest.config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import team.sakak.codingtest.dto.ErrorRes;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorRes> handleIllegalArgument(
            IllegalArgumentException ex, HttpServletRequest request) {

        log.warn("잘못된 요청: {}", ex.getMessage());

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

        log.warn("엔티티를 찾을 수 없음: {}", ex.getMessage());

        ErrorRes response = ErrorRes.of(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                "NOT_FOUND",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRes> handleGeneralException(
            Exception ex, HttpServletRequest request) {

        log.error("예상치 못한 서버 오류 발생", ex); // 스택 트레이스 포함

        ErrorRes response = ErrorRes.of(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "서버 내부 오류가 발생했습니다.",
                "INTERNAL_ERROR",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}