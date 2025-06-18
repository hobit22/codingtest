package team.sakak.codingtest.dto;

public record FoodSearchCondition(
        String foodName,       // 식품이름
        String researchYear,   // 연도(YYYY)
        String makerName,      // 지역/제조사
        String foodCode        // 식품코드
) {
}
