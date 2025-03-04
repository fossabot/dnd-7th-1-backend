package com.dnd.ground.domain.challenge.dto;

import com.dnd.ground.domain.challenge.ChallengeType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * @description 챌린지 생성과 관련한 Request DTO
 * @author  박찬호
 * @since   2022-08-03
 * @updated 1. API 명세 수정
 *          - 2022.08.18 박찬호
 */

@Data
@AllArgsConstructor
public class ChallengeCreateRequestDto {

    @NotNull(message = "UUID가 필요합니다.")
    @ApiModelProperty(value="UUID", example="11ed1e42ae1af37a895b2f2416025f66", required = true)
    private String uuid;

    @NotNull(message = "주최자의 닉네임이 필요합니다.")
    @ApiModelProperty(value="닉네임", example="NickA", required = true)
    private String nickname;
    
    @NotNull(message = "챌린지 이름이 필요합니다.")
    @ApiModelProperty(value="챌린지 이름", example="챌린지1", required = true)
    private String name;

    @ApiModelProperty(value="신청 메시지", example="챌린지 신청 메시지")
    private String message;

    @JsonDeserialize(using= LocalDateDeserializer.class)
    @JsonSerialize(using= LocalDateSerializer.class)
    @ApiModelProperty(value = "챌린지 시작 날짜", example = "2022-08-04")
    private LocalDate started;

    @NotNull(message = "1개의 챌린지 종류가 필요합니다.")
    @ApiModelProperty(value="챌린지 종류(영역: Widen || 칸: Accumulate)", example="Accumulate", required = true)
    private ChallengeType type;

    @NotNull(message = "함께하는 친구가 1명 이상이어야 합니다.")
    @ApiModelProperty(value="함께하는 친구 닉네임 리스트", example="[NickB, NickC]", required = true)
    private Set<String> friends;

}
