package com.toy.jwtJpa.model.service;

import com.toy.jwtJpa.model.domain.Member;
import com.toy.jwtJpa.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) throws Exception {
        return memberRepository.save(member);
    }

    @Override
    public Member findByNo(Long no) throws Exception {
        return memberRepository.findOne(no);
    }

    @Override
    public Member findMemberByName(String name) throws Exception {
        return memberRepository.findOneByName(name);
    }

    @Override
    public Member findMemberByEmail(String email) throws Exception {
        return memberRepository.findOneByEmail(email);
    }

    @Override
    public List<Member> findAll() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findByNameContaining(String name) throws Exception {
        return memberRepository.findByNameContaining(name);
    }

    @Override
    public void update(Member member) throws Exception {
        memberRepository.update(member);
    }

    @Override
    public void delete(Member member) throws Exception {
        memberRepository.unUsed(member);
    }
}
