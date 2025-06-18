package team.sakak.codingtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sakak.codingtest.dto.FoodResDto;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.dto.PageRes;
import team.sakak.codingtest.entity.Food;
import team.sakak.codingtest.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public PageRes<FoodResDto> getList(FoodSearchCondition condition, Pageable pageable) {
        Page<Food> page = foodRepository.getFoods(
                condition,
                pageable
        );

        Page<FoodResDto> dtoPage = page.map(FoodResDto::of);
        return PageRes.from(dtoPage);
    }

}
