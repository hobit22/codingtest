package team.sakak.codingtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sakak.codingtest.dto.FoodResDto;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.dto.PageRes;
import team.sakak.codingtest.service.FoodService;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/foods")
    public PageRes<FoodResDto> getFoods(FoodSearchCondition dto, Pageable pageable) {
        return foodService.getList(dto, pageable);
    }
}
