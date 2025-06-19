package team.sakak.codingtest.dto;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRes.class),
                        examples = @ExampleObject(value = """
            {
              "timestamp": "2025-06-20T12:00:00",
              "status": 400,
              "error": "Bad Request",
              "message": "요청 파라미터가 유효하지 않습니다.",
              "code": "INVALID_ARGUMENT",
              "path": "/api/foods"
            }
            """)
                )
        ),
        @ApiResponse(responseCode = "404", description = "리소스를 찾을 수 없습니다.",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRes.class),
                        examples = @ExampleObject(value = """
            {
              "timestamp": "2025-06-20T12:01:00",
              "status": 404,
              "error": "Not Found",
              "message": "데이터가 존재하지 않습니다.",
              "code": "NOT_FOUND",
              "path": "/api/foods/999"
            }
            """)
                )
        ),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류입니다.",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRes.class),
                        examples = @ExampleObject(value = """
            {
              "timestamp": "2025-06-20T12:02:00",
              "status": 500,
              "error": "Internal Server Error",
              "message": "서버 내부 오류가 발생했습니다.",
              "code": "INTERNAL_ERROR",
              "path": "/api/foods"
            }
            """)
                )
        )
})
public @interface CommonErrorResponses {}