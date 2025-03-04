package com.dnd.ground.domain.user;

import com.dnd.ground.domain.challenge.UserChallenge;
import com.dnd.ground.domain.exerciseRecord.ExerciseRecord;
import com.dnd.ground.domain.friend.Friend;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 회원 엔티티
 * @author  박찬호, 박세헌
 * @since   2022.07.28
 * @updated 1. 카카오 리프레시 토큰 추가
 *  *          - 2022-09-12 박찬호
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
@Entity
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "kakao_id")
    private Long kakaoId;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Email
    @Column(unique = true)
    private String mail;

    @Column
    private String intro;

    @Column(name = "user_latitude")
    private Double latitude;

    @Column(name = "user_longitude")
    private Double longitude;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(name="is_show_mine", nullable = false)
    private Boolean isShowMine;

    @Column(name="is_show_friend", nullable = false)
    private Boolean isShowFriend;

    @Column(name="is_public_record", nullable = false)
    private Boolean isPublicRecord;

    /**
     * 카카오 프로필 사진 → S3 저장X | 파일 이름: kakao/카카오회원번호
     * 자체 프로필 사진 → S3 저장 | 파일 이름: user/profile/닉네임-생성시간
     */
    @Column(name="picture_name", nullable = false)
    private String pictureName;

    @Column(name="picture_path", nullable = false)
    private String picturePath;

    @Column(name="refresh_token")
    private String refreshToken;

    @Column(name = "kakao_refresh_token")
    private String kakaoRefreshToken;

    @OneToMany(mappedBy = "friend")
    private List<Friend> friends = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserChallenge> challenges = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ExerciseRecord> exerciseRecords = new ArrayList<>();

    //마지막 위치 최신화
    public void updatePosition(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //"나의 기록 보기" 필터 변경
    public Boolean changeFilterMine() {
        this.isShowMine = !this.isShowMine;
        return this.isShowMine;
    }

    //"친구 보기" 필터 변경
    public Boolean changeFilterFriend() {
        this.isShowFriend = !this.isShowFriend;
        return this.isShowFriend;
    }

    //"친구들에게 보이기" 필터 변경
    public Boolean changeFilterRecord() {
        this.isPublicRecord = !this.isPublicRecord;
        return this.isPublicRecord;
    }

    public void updateProfile(String nickname, String intro) {
        this.nickname = nickname;
        this.intro = intro;
    }

    //프로필 사진 변경
    public void updatePicture(String pictureName, String picturePath) {
        this.pictureName = pictureName;
        this.picturePath = picturePath;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}