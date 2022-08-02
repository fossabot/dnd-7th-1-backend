package com.dnd.ground.domain.exerciseRecord.controller;

import com.dnd.ground.domain.exerciseRecord.dto.EndRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description 기록 컨트롤러 인터페이스
 *              1. 기록 시작-끝
 * @author  박세헌
 * @since   2022-08-01
 * @updated 2022-08-02 / 생성 : 박세헌
 */

public interface RecordController {
    ResponseEntity<?> start(@RequestParam("nickName") String nickname);
    ResponseEntity<?> end(@RequestBody EndRequestDto endRequestDto);
}
