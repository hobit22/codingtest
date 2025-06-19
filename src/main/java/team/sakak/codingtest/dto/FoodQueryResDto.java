package team.sakak.codingtest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import team.sakak.codingtest.entity.Food;

@Builder
@Schema(description = "음식 조회 응답 DTO")
public record FoodQueryResDto(
        @Schema(description = "번호", example = "1")
        Long id,
        @Schema(description = "식품코드", example = "D000007")
        String foodCd,
        @Schema(description = "식품군", example = "음식")
        String groupName,
        @Schema(description = "식품이름", example = "닭갈비")
        String foodName,
        @Schema(description = "조사년도", example = "2019")
        String researchYear,
        @Schema(description = "지역/제조사", example = "전국(대표)")
        String makerName,
        @Schema(description = "자료출처", example = "식품의약품안전처")
        String refName,
        @Schema(description = "1회 제공량", example = "400")
        Double servingSize,
        @Schema(description = "열량(kcal)", example = "595.61")
        Double calorie,
        @Schema(description = "탄수화물(g)", example = "38.2")
        Double carbohydrate,
        @Schema(description = "단백질(g)", example = "3.5")
        Double protein,
        @Schema(description = "지방(g)", example = "0.5")
        Double province,
        @Schema(description = "총당류(g)", example = "0.6")
        Double sugars,
        @Schema(description = "나트륨(mg)", example = "5.0")
        Double salt,
        @Schema(description = "콜레스테롤(mg)", example = "0.0")
        Double cholesterol,
        @Schema(description = "포화지방산(g)", example = "0.1")
        Double saturatedFattyAcids,
        @Schema(description = "트랜스지방(g)", example = "0.0")
        Double transFat
) {
    public static FoodQueryResDto of(Food food) {
        return FoodQueryResDto.builder()
                .id(food.getId())
                .foodCd(food.getFoodCd())
                .groupName(food.getGroupName())
                .foodName(food.getFoodName())
                .researchYear(food.getResearchYear())
                .makerName(food.getMakerName())
                .refName(food.getRefName())
                .servingSize(food.getServingSize())
                .calorie(food.getCalorie())
                .carbohydrate(food.getCarbohydrate())
                .protein(food.getProtein())
                .province(food.getProvince())
                .sugars(food.getSugars())
                .salt(food.getSalt())
                .cholesterol(food.getCholesterol())
                .saturatedFattyAcids(food.getSaturatedFattyAcids())
                .transFat(food.getTransFat())
                .build();
    }
}