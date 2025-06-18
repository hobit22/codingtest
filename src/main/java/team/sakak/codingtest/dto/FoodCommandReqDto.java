package team.sakak.codingtest.dto;

import team.sakak.codingtest.entity.Food;

public record FoodCommandReqDto(
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

    public Food toEntity() {
        return Food.builder()
                .calorie(calorie)
                .carbohydrate(carbohydrate)
                .foodCd(foodCd)
                .foodName(foodName)
                .groupName(groupName)
                .makerName(makerName)
                .province(province)
                .researchYear(researchYear)
                .servingSize(servingSize)
                .saturatedFattyAcids(saturatedFattyAcids)
                .salt(salt)
                .sugars(sugars)
                .cholesterol(cholesterol)
                .protein(protein)
                .refName(refName)
                .transFat(transFat)
                .build();
    }
}
