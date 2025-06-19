package team.sakak.codingtest.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import team.sakak.codingtest.dto.FoodCommandReqDto;
import team.sakak.codingtest.dto.FoodQueryResDto;
import team.sakak.codingtest.dto.FoodSearchCondition;
import team.sakak.codingtest.dto.PageRes;
import team.sakak.codingtest.entity.Food;
import team.sakak.codingtest.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FoodServiceTest {

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    public FoodServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Food 목록 조회")
    void getListTest() {
        FoodSearchCondition condition = new FoodSearchCondition(null, null, null, null);
        Pageable pageable = PageRequest.of(0, 10);
        Food food = Food.builder().build();
        Page<Food> page = new PageImpl<>(List.of(food));

        when(foodRepository.getFoods(condition, pageable)).thenReturn(page);

        PageRes<FoodQueryResDto> result = foodService.getList(condition, pageable);

        assertThat(result.content()).hasSize(1);
        verify(foodRepository).getFoods(condition, pageable);
    }

    @Test
    @DisplayName("Food 생성")
    void createTest() {
        FoodCommandReqDto dto = mock(FoodCommandReqDto.class);
        Food food = Food.builder().build();

        when(dto.toEntity()).thenReturn(food);
        when(foodRepository.save(food)).thenReturn(food);

        FoodQueryResDto result = foodService.create(dto);

        assertThat(result).isNotNull();
        verify(foodRepository).save(food);
    }

    @Test
    @DisplayName("Food 단건 조회 성공")
    void readTest() {
        Long id = 1L;
        Food food = Food.builder().build();
        when(foodRepository.findById(id)).thenReturn(Optional.of(food));

        FoodQueryResDto result = foodService.read(id);

        assertThat(result).isNotNull();
        verify(foodRepository).findById(id);
    }

    @Test
    @DisplayName("Food 단건 조회 실패")
    void readNotFoundTest() {
        Long id = 1L;
        when(foodRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.read(id));
    }

    @Test
    @DisplayName("Food 수정")
    void updateTest() {
        Long id = 1L;
        FoodCommandReqDto dto = mock(FoodCommandReqDto.class);
        Food original = mock(Food.class);
        Food updated = mock(Food.class);

        when(foodRepository.findById(id)).thenReturn(Optional.of(original));
        when(dto.toEntity()).thenReturn(updated);

        FoodQueryResDto result = foodService.update(id, dto);

        assertThat(result).isNotNull();
        verify(original).updateWith(updated);
    }

    @Test
    @DisplayName("Food 삭제")
    void deleteTest() {
        Long id = 1L;
        Food food = Food.builder().build();

        when(foodRepository.findById(id)).thenReturn(Optional.of(food));

        foodService.delete(id);

        verify(foodRepository).delete(food);
    }
}