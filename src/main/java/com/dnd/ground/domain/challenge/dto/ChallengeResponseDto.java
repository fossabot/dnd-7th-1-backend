package com.dnd.ground.domain.challenge.dto;

import com.dnd.ground.domain.challenge.ChallengeColor;
import com.dnd.ground.domain.challenge.ChallengeType;
import com.dnd.ground.domain.matrix.dto.MatrixDto;
import com.dnd.ground.domain.user.dto.UserResponseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @description 챌린지와 관련한 Response DTO
 * @author  박찬호
 * @since   2022-08-12
 * @updated 1. 프로필 사진 추가 - 2022-10-10 박세헌
 */


public class ChallengeResponseDto {

    /*상태에 상관 없이 사용되는 챌린지 관련 공통 정보*/
    @Data
    @Builder
    @AllArgsConstructor
    static public class CInfoRes {
        @ApiModelProperty(value="챌린지 이름", example="챌린지1")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="챌린지 시작 날짜", example="2022-08-18")
        private LocalDate started;

        @ApiModelProperty(value = "챌린지 종료 날짜(시작 날짜 주의 일요일)", example = "2022-08-12")
        private LocalDate ended;

        @ApiModelProperty(value="챌린지 색깔", example="Red")
        private ChallengeColor color;
    }

    /*진행 대기 중 상태의 챌린지 정보*/
    @Data
    @AllArgsConstructor
    @Builder
    static public class Wait {
        @ApiModelProperty(value="챌린지 이름", example="챌린지1")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="챌린지 시작 날짜", example="2022-08-12")
        private LocalDate started;

        @ApiModelProperty(value="챌린지 종료 날짜(시작 날짜 주의 일요일)", example="2022-08-14")
        private LocalDate ended;

        @ApiModelProperty(value="챌린지에 참여하는 전체 인원", example="4")
        private Integer totalCount;

        @ApiModelProperty(value="챌린지를 수락한 인원(주최자 포함)", example="2")
        private Integer readyCount;

        @ApiModelProperty(value="챌린지 색깔(Red, Pink, Yellow)", example="Red")
        private ChallengeColor color;

        @ApiModelProperty(value="인원들의 프로필 사진 URI 리스트(카카오 프로필 사용 시 kakao/카카오회원번호)", example="http:\\/\\/k.kakaocdn.net\\/dn\\/uQVeo\\/btrLgESJyjg\\/Pff3k36lRWkQ98ebAlexv1\\/img_640x640.jpg")
        private List<String> picturePaths;
    }

    /*진행 중 상태의 챌린지 정보*/
    @Data
    @Builder
    static public class Progress {
        @ApiModelProperty(value="챌린지 이름", example="챌린지1")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="챌린지 시작 날짜", example="2022-08-15")
        private LocalDate started;

        @ApiModelProperty(value="챌린지 종료 날짜(시작 날짜 주의 일요일)", example="2022-08-15")
        private LocalDate ended;

        @ApiModelProperty(value="챌린지 내 랭킹(영역)", example="2")
        private Integer rank;

        @ApiModelProperty(value="챌린지 색깔", example="Red")
        private ChallengeColor color;

        @ApiModelProperty(value="인원들의 프로필 사진 URI 리스트(카카오 프로필 사용 시 kakao/카카오회원번호)", example="http:\\/\\/k.kakaocdn.net\\/dn\\/uQVeo\\/btrLgESJyjg\\/Pff3k36lRWkQ98ebAlexv1\\/img_640x640.jpg")
        private List<String> picturePaths;
    }

    /*진행 완료 상태의 챌린지 정보*/
    @Data
    @Builder
    static public class Done {
        @ApiModelProperty(value="챌린지 이름", example="챌린지1")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="챌린지 시작 날짜", example="2022-08-15")
        private LocalDate started;

        @ApiModelProperty(value="챌린지 종료 날짜(시작 날짜 주의 일요일)", example="2022-08-15")
        private LocalDate ended;

        @ApiModelProperty(value="챌린지 내 랭킹(영역)", example="2")
        private Integer rank;

        @ApiModelProperty(value="챌린지 색깔", example="Red")
        private ChallengeColor color;

        @ApiModelProperty(value="인원들의 프로필 사진 URI 리스트(카카오 프로필 사용 시 kakao/카카오회원번호)", example="http:\\/\\/k.kakaocdn.net\\/dn\\/uQVeo\\/btrLgESJyjg\\/Pff3k36lRWkQ98ebAlexv1\\/img_640x640.jpg")
        private List<String> picturePaths;
    }

    /*초대 받은 챌린지 정보*/
    @Data
    @Builder
    static public class Invite {
        @ApiModelProperty(value="챌린지 이름", example="챌린지A")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="주최자 닉네임(초대자)", example="NickA")
        private String InviterNickname;

        @ApiModelProperty(value="초대 메시지(Nullable)", example="초대 메시지입니다.")
        private String message;

        @ApiModelProperty(value="초대 시간(yyyy-MM-dd hh:mm)", example="2022-08-12 22:10")
        private String created;

        @ApiModelProperty(value="주최자의 프로필 사진 URI(카카오 프로필 사용 시 kakao/카카오회원번호)", example="http:\\/\\/k.kakaocdn.net\\/dn\\/uQVeo\\/btrLgESJyjg\\/Pff3k36lRWkQ98ebAlexv1\\/img_640x640.jpg")
        private String picturePath;
    }

    /*챌린지 상세 보기*/
    @Data
    @Builder
    static public class Detail {
        @ApiModelProperty(value="챌린지 이름", example="챌린지1")
        private String name;

        @ApiModelProperty(value="챌린지 UUID", example="11ed1e26d25aa6b4b02fbb2d0e652b0f")
        private String uuid;

        @ApiModelProperty(value="챌린지 종류(영역:Widen || 칸:Accumulate)", example="Widen")
        private ChallengeType type;

        @ApiModelProperty(value="챌린지 색상(Red, Pink, Yellow)", example="Pink")
        private ChallengeColor color;

        @ApiModelProperty(value="챌린지 시작 날짜", example="2022-08-17")
        private LocalDate started;

        @ApiModelProperty(value="챌린지 종료 날짜", example="2022-08-21", dataType = "LocalDate", notes="챌린지 종료 날짜(일요일)")
        private LocalDate ended;

        @ApiModelProperty(value="영역 정보", example="[{\"latitude\": 1.0,\"longitude\": 1.0}]")
        private List<MatrixDto> matrices;

        @ApiModelProperty(value="랭킹 정보", example="[{\"rank\": 1, \"nickname\": \"NickB\", \"score\": 4}]")
        private List<UserResponseDto.Ranking> rankings;

        //내 기록
        @ApiModelProperty(value="거리", example="100")
        private Integer distance;

        @ApiModelProperty(value="운동 시간", example="15")
        private Integer exerciseTime;

        @ApiModelProperty(value="걸음 수", example="15")
        private Integer stepCount;
    }
}