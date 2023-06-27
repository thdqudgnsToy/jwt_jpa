package com.toy.jwtJpa.controller;

import com.toy.jwtJpa.model.domain.Member;
import com.toy.jwtJpa.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    /*
        가입 POST /member
        조회 GET /member/{id}
        목록 GET /member
        수정 PUT /member
        삭제 DELETE /member
     */

    @PostMapping
    public void join(Member member) throws Exception {
        memberService.join(member);
    }

    @GetMapping("/{no}")
    public Member findById(@PathVariable Long no) throws Exception {
        return memberService.findByNo(no);
    }

    @GetMapping
    public void findAll() throws Exception {
        memberService.findAll();
    }

    @PutMapping
    public void update(Member member) throws Exception {
        memberService.update(member);
    }

    @DeleteMapping
    public void delete(Member member) throws Exception {
        memberService.delete(member);
    }

}
