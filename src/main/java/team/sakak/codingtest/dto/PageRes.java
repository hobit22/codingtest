package team.sakak.codingtest.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageRes<T>(
        List<T> content,
        int page,          // 현재 페이지 번호 (0부터 시작)
        int size,          // 페이지 크기
        long totalElements,
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