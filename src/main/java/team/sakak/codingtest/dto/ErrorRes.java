package team.sakak.codingtest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(description = "에러 응답")
public record ErrorRes(
        @Schema(description = "에러 발생 시간", example = "2025-06-20T12:34:56")
        LocalDateTime timestamp,

        @Schema(description = "HTTP 상태 코드", example = "404")
        int status,

        @Schema(description = "HTTP 상태 메시지", example = "Not Found")
        String error,

        @Schema(description = "에러 상세 메시지", example = "존재하지 않는 Food: 9999")
        String message,

        @Schema(description = "애플리케이션 에러 코드", example = "INVALID_ARGUMENT", allowableValues = {
                "INVALID_ARGUMENT", "NOT_FOUND", "INTERNAL_ERROR", "DUPLICATE_RESOURCE"
        })
        String code,

        @Schema(description = "요청 경로", example = "/api/foods/9999")
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