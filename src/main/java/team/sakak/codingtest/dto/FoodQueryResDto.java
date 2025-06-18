package team.sakak.codingtest.dto;

import lombok.Builder;
import team.sakak.codingtest.entity.Food;

@Builder
public record FoodQueryResDto(
        Long id,                          // 번호
        String foodCd,                    // 식품코드
        String groupName,                // 식품군
        String foodName,                 // 식품이름
        String researchYear,             // 조사년도
        String makerName,                // 지역/제조사
        String refName,                  // 자료출처
        Double servingSize,              // 1회 제공량
        Double calorie,                  // 열량(kcal)(1회제공량당)
        Double carbohydrate,             // 탄수화물(g)(1회제공량당)
        Double protein,                  // 단백질(g)(1회제공량당)
        Double province,                 // 지방(g)(1회제공량당)
        Double sugars,                   // 총당류(g)(1회제공량당)
        Double salt,                     // 나트륨(mg)(1회제공량당)
        Double cholesterol,              // 콜레스테롤(mg)(1회제공량당)
        Double saturatedFattyAcids,      // 포화지방산(g)(1회제공량당)
        Double transFat                  // 트랜스지방(g)(1회제공량당)
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