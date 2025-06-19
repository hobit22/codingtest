package team.sakak.codingtest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record FoodSearchCondition(
        @Schema(description = "식품이름 포함", example = "닭")
        String foodName,

        @Schema(description = "연도(YYYY) 일치", example = "2019")
        String researchYear,

        @Schema(description = "지역/제조사 포함", example = "전국(대표)")
        String makerName,

        @Schema(description = "식품코드 포함", example = "D000007")
        String foodCode
) {
}