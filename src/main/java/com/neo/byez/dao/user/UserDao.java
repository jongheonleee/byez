package com.neo.byez.dao.user;


import com.neo.byez.domain.user.UserDto;

import java.sql.Timestamp;
import java.util.List;

public interface UserDao {

    // 현재 시간 확인하는 select 문
    Timestamp selectNow() throws Exception;

    // 테스트용 delete 문에 대한 메서드
    int deleteUser(String id) throws Exception;
    int deleteAllUser() throws Exception;

    // *** INSERT, UPDATE 문에 시스템 컬럼 필수로 넣어줄 것

    // 회원가입한 전체 고객의 수
    int countUser() throws Exception;

    // 탈퇴회원 제외한 전체 고객의 수
    int countActiveUser() throws Exception;

    // 회원가입한 전체 고객 조회
    List<UserDto> selectUserAll() throws Exception;

    // UPDATE
    // SNS 계정 연동 성공 시 닉네임 저장
    int updateKakaoNickname(String id, String nickname) throws Exception;

    // UPDATE
    // SNS 계정(네이버) 연동 성공 시 닉네임 저장
    int updateNaverNickname(String id, String nickname) throws Exception;

    String selectUserIdByNickname(String nickname) throws Exception;

    // 1. SELECT (=READ; 조회 기능)
    // 1.1. 로그인
    // 1.1.1. 로그인 시 selectUser 문으로 'cust' table 의 전체 데이터 조회 가능
    // 1.1.1.1. view 에서 입력한 id 를 매개변수로 받고 UserDto 인스턴스에 고객 정보 담아서 반환
    UserDto selectUser(String id) throws Exception;
    // 1.1.2. 탈퇴 회원을 제외한, 가입상태 'Y' 인 회원 모두 조회
    List<UserDto> selectActiveUserAll() throws Exception;

    // 1.2. 아이디 찾기
    // 1.2.1. 인증된 이메일로 식별된 특정 회원의 아이디 조회
    UserDto selectUserId(UserDto userDto) throws Exception;

    // 1.3. 비밀번호 찾기

    // 2. INSERT
    // 2.1. 회원가입
    // 2.1.1. 이름, 아이디, 비밀번호, 생년월일, 성별, 전화번호, 휴대폰 번호, 주소, 이메일 데이터 추가
    // view 에서 입력한 고객 정보를 UserDto 인스턴스로 받아서 처리하고, 따로 특정 반환 사항 없이 실행 됐으면 1 반환
    int insertUser(UserDto userDto) throws Exception;

    // 3. UPDATE
    // view 에서 입력한 id 를 매개변수로 받고 UserDto 인스턴스에 수정된 고객 정보 담아서 반환
    // 3.1. 로그인
    // 3.1.1. 로그인 시 최근 로그인 일시 업데이트
    int updateRecentLoginDatetime(String id) throws Exception;

    // 3.2. 비밀번호 찾기
    // 3.1.2. 비밀번호 찾기 시 새로운 비밀번호로 변경
    int updateUserPwd(String id, String pwd) throws Exception;


    // 3.3. 회원탈퇴
    // 3.3.1. 회원가입 상태를 Y -> N 으로 변경
    int updateUserState(String id) throws Exception;

    // 3.3.2. 전체 가입고객(탈퇴회원 포함) 중 특정 아이디를 가진 고객 존재여부 확인
    UserDto selectAllUserId(String id) throws Exception;

    // 3.4. 이메일 인증
    // 3.4.1. 이메일 인증번호 받을 때마다 mail_key 컬럼에 저장
    int updateMailKey(UserDto userDto) throws Exception;

    // 3.5. 고객 정보 변경
    // 3.5.1. 이메일 변경
    // 3.5.2. 생년월일 변경
    // 3.5.3. 핸드폰 번호 변경
    int updateUserEmail(String id, String email) throws Exception;
//    int updateUserBefBirth(String id, Integer bef_birth) throws Exception;
    int updateUserMobileNum(String id, Integer mobile_num) throws Exception;
}
