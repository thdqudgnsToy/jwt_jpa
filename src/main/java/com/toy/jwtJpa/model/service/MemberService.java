package com.toy.jwtJpa.model.service;

import com.toy.jwtJpa.model.domain.Member;

import java.util.List;

public interface MemberService {

    /**
     * 회원 저장
     */
    Long join(Member member) throws Exception;

    /**
     * 회원 no로 회원 조회
     */
    Member findByNo(Long no) throws Exception;

    /**
     * 회원 이름으로 회원 한 명 조회
     */
    Member findMemberByName(String name) throws Exception;

    /**
     * 이메일로 회원 조회
     */
    Member findMemberByEmail(String email) throws Exception;

    /**
     * 회원 목록 조회
     */
    List<Member> findAll() throws Exception;

    /**
     * 이름이 들어있는 회원 목록 조회
     */
    List<Member> findByNameContaining(String name) throws Exception;

    /**
     * 회원 정보 수정
     */
    void update(Member member) throws Exception;

    /**
     * 회원 비활성화
     */
    void delete(Long no) throws Exception;
}
