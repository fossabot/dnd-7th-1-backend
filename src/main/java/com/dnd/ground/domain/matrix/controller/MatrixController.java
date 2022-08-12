package com.dnd.ground.domain.matrix.controller;

import com.dnd.ground.domain.user.dto.RankResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface MatrixController {
    ResponseEntity<RankResponseDto.Matrix> matrixRank(@RequestParam("nickname") String nickName);
    ResponseEntity<RankResponseDto.Area> areaRank(@RequestParam("nickname") String nickName);
}
