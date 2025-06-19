package team.sakak.codingtest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sakak.codingtest.dto.*;
import team.sakak.codingtest.service.FoodService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @Operation(summary = "음식 목록 조회", description = "검색 조건과 페이징 정보를 기반으로 음식 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "정상 조회",
            content = @Content(schema = @Schema(implementation = FoodQueryResDto.class)))
    @CommonErrorResponses
    @GetMapping
    public ResponseEntity<PageRes<FoodQueryResDto>> getFoods(
            @ParameterObject FoodSearchCondition condition,
            @ParameterObject Pageable pageable) {
        return ResponseEntity.ok(foodService.getList(condition, pageable));
    }

    @Operation(summary = "음식 등록", description = "새로운 음식 정보를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "정상 등록")
    @CommonErrorResponses
    @PostMapping
    public ResponseEntity<FoodQueryResDto> create(@RequestBody FoodCommandReqDto dto) {
        return ResponseEntity.ok(foodService.create(dto));
    }

    @Operation(summary = "음식 조회", description = "ID로 음식 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "정상 조회")
    @CommonErrorResponses
    @GetMapping("/{id}")
    public ResponseEntity<FoodQueryResDto> read(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.read(id));
    }

    @Operation(summary = "음식 수정", description = "기존 음식 정보를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "정상 수정")
    @CommonErrorResponses
    @PutMapping("/{id}")
    public ResponseEntity<FoodQueryResDto> update(@PathVariable Long id, @RequestBody FoodCommandReqDto dto) {
        return ResponseEntity.ok(foodService.update(id, dto));
    }

    @Operation(summary = "음식 삭제", description = "음식 ID를 통해 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "삭제 성공 (내용 없음)")
    @CommonErrorResponses
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
