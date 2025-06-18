package team.sakak.codingtest.dto;

import team.sakak.codingtest.entity.Food;

public record FoodResDto(
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
    public static FoodResDto of(Food food) {
        return new FoodResDto(
                food.getId(),
                food.getFoodCd(),                    // 식품코드
                food.getGroupName(),                // 식품군
                food.getFoodName(),                 // 식품이름
                food.getResearchYear(),             // 조사년도
                food.getMakerName(),                // 지역/제조사
                food.getRefName(),                  // 자료출처
                food.getServingSize(),              // 1회 제공량
                food.getCalorie(),                  // 열량(kcal)(1회제공량당)
                food.getCarbohydrate(),             // 탄수화물(g)(1회제공량당)
                food.getProtein(),                  // 단백질(g)(1회제공량당)
                food.getProvince(),                 // 지방(g)(1회제공량당)
                food.getSugars(),                   // 총당류(g)(1회제공량당)
                food.getSalt(),                     // 나트륨(mg)(1회제공량당)
                food.getCholesterol(),              // 콜레스테롤(mg)(1회제공량당)
                food.getSaturatedFattyAcids(),      // 포화지방산(g)(1회제공량당)
                food.getTransFat()                 // 트랜스지방(g)(1회제공량당)
        );
    }
}