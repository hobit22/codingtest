package team.sakak.codingtest.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorRes(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String code,
        String path
) {
    public static ErrorRes of(HttpStatus status, String message, String code, String path) {
        return new ErrorRes(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                code,
                path
        );
    }
}
