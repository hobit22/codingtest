package team.sakak.codingtest.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.entity.Food;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static team.sakak.codingtest.entity.QFood.food;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodCustomRepository {

    private final JPAQueryFactory queryFactory;

    public Page<Food> getFoods(FoodSearchCondition condition, Pageable pageable) {
        List<Food> content = queryFactory
                .selectFrom(food)
                .where(
                        buildCondition(condition)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(food.count())
                .from(food)
                .where(
                        buildCondition(condition)
                )
                .fetchOne();


        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression buildCondition(FoodSearchCondition condition) {
        return Stream.of(
                        containFoodName(condition.foodName()),
                        containFoodCode(condition.foodCode()),
                        eqResearchYear(condition.researchYear()),
                        containMakerName(condition.makerName())
                ).filter(Objects::nonNull)
                .reduce(BooleanExpression::and)
                .orElse(null);
    }

    private BooleanExpression containFoodName(String foodName) {
        return foodName != null ? food.foodName.containsIgnoreCase(foodName) : null;
    }

    private BooleanExpression eqResearchYear(String researchYear) {
        return researchYear != null ? food.researchYear.eq(researchYear) : null;
    }

    private BooleanExpression containMakerName(String makerName) {
        return makerName != null ? food.makerName.containsIgnoreCase(makerName) : null;
    }

    private BooleanExpression containFoodCode(String foodCode) {
        return foodCode != null ? food.foodCd.containsIgnoreCase(foodCode) : null;
    }
}
