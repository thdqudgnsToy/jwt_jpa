package com.toy.jwtJpa.model.service;

import com.toy.jwtJpa.model.domain.Member;
import com.toy.jwtJpa.model.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired MemberService memberService;

    @Test
    // given - 회원 객체를 만들어서
    // when - 가입을 했을 때
    // then - 가입된 정보를 확인하는 메소드가 제대로 동작하는가
    void join() throws Exception {

        Member member = new Member();
        member.setName("memberA");
        member.setEmail("emailA");
        member.setId("memberA");
        member.setPassword("XXXXXXX");

        memberService.join(member);

        Member findMember = memberService.findMemberByName("memberA");
        assertEquals(member, findMember);
        System.out.println("member == findMember? " + (member == findMember));
        System.out.println("member.getName() = " + member.getName());
        System.out.println("findMember.getName() = " + findMember.getName());
        System.out.println("member.getUsed() = " + findMember.getUsed());
    }

    @Test
    // given - 회원정보를 생성하고
    // when - 저장했을 때
    // then - 번호로 동일한 회원 정보를 가져오는가
    void findByNo() throws Exception {

        Member member = new Member();
        member.setName("memberA");

        Long memberNo = memberService.join(member);

        Member findMember = memberService.findByNo(memberNo);
        assertEquals(member, findMember);
        System.out.println("member == findMember? " + (member == findMember));
        System.out.println("member.getNo() = " + member.getNo());
        System.out.println("findMember.getNo() = " + findMember.getNo());
    }

    @Test
    // given - 회원정보를 생성하고
    // when - 저장했을 때
    // then - 이메일로 동일한 회원 정보를 가져오는가
    void findMemberByEmail() throws Exception {

        Member member = new Member();
        member.setEmail("memberA@email.com");

        memberService.join(member);

        Member findMember = memberService.findMemberByEmail("memberA@email.com");
        assertEquals(member, findMember);
        System.out.println("member == findMember? " + (member == findMember));
        System.out.println("member.getEmail() = " + member.getEmail());
        System.out.println("findMember.getEmail() = " + findMember.getEmail());
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }

    @Test
    // given - 두 명의 회원을 생성하고
    // when - 저장했을 때
    // then - 두 명의 회원이 조회되는가
    void findAll() throws Exception {

        Member member1 = new Member();
        member1.setId("memberA");
        Member member2 = new Member();
        member2.setId("memberB");

        memberService.join(member1);
        memberService.join(member2);

        List<Member> members = memberService.findAll();
        assertEquals(2, members.size());
        for (Member m : members) {
            System.out.println("m = " + m);
        }
    }

    @Test
    // given - 이름이 비슷한 두 명의 회원을 생성하고 저장한다
    // when - 동일한 이름의 문자를 매개로 검색했을 때
    // then - 두 명의 회원이 조회되는가.
    void findByNameContaining() throws Exception {

        Member member1 = new Member();
        member1.setName("홍길동");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("박길흠");
        memberService.join(member2);

        List<Member> members = memberService.findByNameContaining("길");

        assertEquals(2, members.size());
        for (Member m : members) {
            System.out.println("m = " + m);
        }
    }

    @Test // JPA에서 수정 테스트 코드는 어떻게 작성하는 거지?
    // given - 회원을 생성하고 저장한 다음에
    // when - 수정했을 때
    // then - 생성한 회원과 수정한 회원의 id가 동일한가.
    void update() throws Exception {
        Member member =  new Member();
        member.setName("memberA");
        member.setEmail("emailA");
        member.setPassword("XXXXX");
        member.setId("idA");

        Long no = memberService.join(member);
        member = memberService.findByNo(no); // 객체 정보가 이미 있으므로 수행되지 않는다. 1차 캐시에서 데이터를 가져온다.
        System.out.println(member);

        member.setName("memberB");
        member.setPassword("OOOOO");
        member.setEmail("emailB");
        memberService.update(member);
        System.out.println(member);

        assertEquals("idA", member.getId());
    }

    @Test
    // given - 두 명의 회원을 생성하고 저장한 다음에
    // when - 한 명의 회원을 비활성화 시켰을 때
    // then - 해당 회원만 비활성화 되었는가
    void delete() throws Exception{
        Member member1 = new Member();
        member1.setName("memberA");
        Member member2 = new Member();
        member2.setName("memberB");

        memberService.join(member1);
        memberService.join(member2);

        memberService.delete(member1);

        assertEquals(0, memberService.findMemberByName("memberA").getUsed());
        assertEquals(1, memberService.findMemberByName("memberB").getUsed());

        List<Member> members = memberService.findAll();

        for (Member m: members) {
            System.out.println(m);
        }
    }
}