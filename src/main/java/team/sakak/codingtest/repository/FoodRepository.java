package team.sakak.codingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.sakak.codingtest.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>, FoodCustomRepository {
}
