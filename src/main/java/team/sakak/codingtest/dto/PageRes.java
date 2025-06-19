package team.sakak.codingtest.dto;

import org.springframework.data.domain.Page;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

public record PageRes<T>(
        @Schema(description = "응답 데이터 리스트")
        List<T> content,

        @Schema(description = "현재 페이지 번호 (0부터 시작)", example = "0")
        int page,

        @Schema(description = "페이지 크기", example = "10")
        int size,

        @Schema(description = "전체 데이터 개수", example = "120")
        long totalElements,

        @Schema(description = "전체 페이지 수", example = "12")
        int totalPages
) {
    public static <T> PageRes<T> from(Page<T> page) {
        return new PageRes<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}