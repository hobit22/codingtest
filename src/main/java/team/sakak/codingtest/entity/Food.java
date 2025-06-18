package team.sakak.codingtest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "foods")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("SAMPLE_ID")
    private String sampleId;

    @Comment("식품 코드")
    private String foodCd;

    @Comment("식품 군")
    private String groupName;

    @Comment("식품 명")
    private String foodName;

    @Comment("조사 연도")
    private String researchYear;

    @Comment("지역/제조사")
    private String makerName;

    @Comment("자료 출처")
    private String refName;

    @Comment("1회 제공량")
    private Double servingSize;

    @Comment("열량(kcal)(1회제공량당)")
    private Double calorie;

    @Comment("탄수화물(g)(1회제공량당)")
    private Double carbohydrate;

    @Comment("단백질(g)(1회제공량당)")
    private Double protein;

    @Comment("지방(g)(1회제공량당)")
    private Double province;

    @Comment("총당류(g)(1회제공량당)")
    private Double sugars;

    @Comment("나트륨(mg)(1회제공량당)")
    private Double salt;

    @Comment("콜레스테롤(mg)(1회제공량당)")
    private Double cholesterol;

    @Comment("포화지방산(g)(1회제공량당)")
    private Double saturatedFattyAcids;

    @Comment("트랜스지방(g)(1회제공량당)")
    private Double transFat;

    public void updateWith(Food other) {
        this.foodCd = other.getFoodCd();
        this.groupName = other.getGroupName();
        this.foodName = other.getFoodName();
        this.researchYear = other.getResearchYear();
        this.makerName = other.getMakerName();
        this.refName = other.getRefName();
        this.servingSize = other.getServingSize();
        this.calorie = other.getCalorie();
        this.carbohydrate = other.getCarbohydrate();
        this.protein = other.getProtein();
        this.province = other.getProvince();
        this.sugars = other.getSugars();
        this.salt = other.getSalt();
        this.cholesterol = other.getCholesterol();
        this.saturatedFattyAcids = other.getSaturatedFattyAcids();
        this.transFat = other.getTransFat();
    }
}

