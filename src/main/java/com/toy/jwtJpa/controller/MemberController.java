package com.toy.jwtJpa.controller;

import com.toy.jwtJpa.model.domain.Member;
import com.toy.jwtJpa.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
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
    public ResponseEntity join(@RequestBody Member member) throws Exception {
        log.debug("member: {}", member);
        memberService.join(member);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/{no}")
    public Member findById(@PathVariable Long no) throws Exception {
        return memberService.findByNo(no);
    }

    @GetMapping
    public List<Member> findAll() throws Exception {
        return memberService.findAll();

    }

    @PutMapping
    public ResponseEntity update(@RequestBody Member member) throws Exception {
        memberService.update(member);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity delete(@PathVariable Long no) throws Exception {
        memberService.delete(no);
        return ResponseEntity.ok().build();
    }

}
