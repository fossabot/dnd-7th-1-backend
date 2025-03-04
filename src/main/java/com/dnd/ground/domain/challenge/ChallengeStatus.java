package com.dnd.ground.domain.challenge;

/**
 * @description 챌린지 상태(Challenge, UserChallenge 둘 다 사용)
 *              Wait     - 수락 대기
 *              Progress - 진행
 *              Done     - 종료
 *              Reject   - 거절
 *              Master   - 주최자
 * @author  박찬호
 * @since   2022-07-26
 * @updated 1. Master - 주최자 추가
 *          2. Reject - 거절 추가
 *          - 2022-08-08 박찬호
 */

public enum ChallengeStatus {
    Wait, Progress, Done, Reject, Master
}
