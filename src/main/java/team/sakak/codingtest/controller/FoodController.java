package team.sakak.codingtest.controller;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sakak.codingtest.dto.FoodCommandReqDto;
import team.sakak.codingtest.dto.FoodQueryResDto;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.dto.PageRes;
import team.sakak.codingtest.service.FoodService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<PageRes<FoodQueryResDto>> getFoods(
            @ParameterObject FoodSearchCondition condition,
            Pageable pageable) {
        return ResponseEntity.ok(foodService.getList(condition, pageable));
    }

    @PostMapping
    public ResponseEntity<FoodQueryResDto> create(@RequestBody FoodCommandReqDto dto) {
        return ResponseEntity.ok(foodService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodQueryResDto> read(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodQueryResDto> update(@PathVariable Long id, @RequestBody FoodCommandReqDto dto) {
        return ResponseEntity.ok(foodService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
