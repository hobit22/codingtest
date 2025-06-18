package team.sakak.codingtest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.entity.Food;

public interface FoodCustomRepository {
    Page<Food> getFoods(FoodSearchCondition condition, Pageable pageable);
}
