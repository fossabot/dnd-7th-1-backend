package com.dnd.ground.domain.challenge.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description 챌린지와 관련한 Request DTO
 * @author  박찬호
 * @since   2022-08-08
 * @updated 1. API 명세 수정
 *          - 2022.08.18 박찬호
 */


@Data
public class ChallengeRequestDto {

    //유저-챌린지 정보를 위한 이너 클래스
    @Data
    static public class CInfo {
        @NotNull(message = "UUID가 필요합니다.")
        @ApiModelProperty(value="UUID", example="11ed1e42ae1af37a895b2f2416025f66", required = true)
        private String uuid;

        @NotNull(message = "닉네임이 필요합니다.")
        @ApiModelProperty(value="회원 닉네임", example="NickA", required = true)
        private String nickname;
    }
}
