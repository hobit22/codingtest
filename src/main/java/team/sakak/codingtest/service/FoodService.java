package team.sakak.codingtest.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.sakak.codingtest.dto.FoodCommandReqDto;
import team.sakak.codingtest.dto.FoodQueryResDto;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.dto.PageRes;
import team.sakak.codingtest.entity.Food;
import team.sakak.codingtest.repository.FoodRepository;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional(readOnly = true)
    public PageRes<FoodQueryResDto> getList(FoodSearchCondition condition, Pageable pageable) {
        Page<Food> page = foodRepository.getFoods(
                condition,
                pageable
        );

        Page<FoodQueryResDto> dtoPage = page.map(FoodQueryResDto::of);
        return PageRes.from(dtoPage);
    }

    @Transactional
    public FoodQueryResDto create(FoodCommandReqDto reqDto) {
        Food food = reqDto.toEntity();
        Food savedFood = foodRepository.save(food);
        return FoodQueryResDto.of(savedFood);
    }

    @Transactional(readOnly = true)
    public FoodQueryResDto read(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 Food: " + id));

        return FoodQueryResDto.of(food);
    }

    @Transactional
    public FoodQueryResDto update(Long id, FoodCommandReqDto dto) {
        Food existing = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 Food: " + id));

        Food updated = dto.toEntity(); // 새로운 값만 담긴 Food 객체

        existing.updateWith(updated); // 기존 엔티티에 복사

        return FoodQueryResDto.of(existing);
    }

    @Transactional
    public void delete(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 Food: " + id));
        foodRepository.delete(food);
    }
}
