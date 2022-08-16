package com.dnd.ground.domain.user.service;

import com.dnd.ground.domain.user.User;
import com.dnd.ground.domain.user.dto.HomeResponseDto;
import com.dnd.ground.domain.user.dto.RankResponseDto;
import com.dnd.ground.domain.user.dto.UserResponseDto;

/**
 * @description 회원 서비스 인터페이스
 * @author  박세헌, 박찬호
 * @since   2022-08-01
 * @updated 1. 친구 프로필 조회 기능 구현
 *          - 2022.08.16 박찬호
 */

public interface UserService {
    User save(User user);
    HomeResponseDto showHome(String nickname);
    UserResponseDto.UInfo getUserInfo(String nickname);

    UserResponseDto.Profile getUserProfile(String userNickname, String friendNickname);
}
