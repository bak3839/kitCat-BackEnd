package com.kitcat.likelion.controller;

import com.kitcat.likelion.requestDTO.LoginDTO;
import com.kitcat.likelion.requestDTO.RegisterDTO;
import com.kitcat.likelion.requestDTO.RoutineCreateDTO;
import com.kitcat.likelion.security.custom.CustomUserDetails;
import com.kitcat.likelion.service.RoutineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/routine")
@Tag(name = "Routine API", description = "routine 도메인 관련 API")
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping("/save")
    @Operation(summary = "루틴 생성 기능", description = "루틴 생성에 사용되는 API")
    @ApiResponse(responseCode = "200", description = "루틴 생성 성공", content = @Content(mediaType = "application/json"))
    public String routineSave(@RequestBody RoutineCreateDTO dto,
                              @AuthenticationPrincipal CustomUserDetails userDetails) {
        routineService.save(userDetails.getUserId(), dto);
        return "success";
    }
}