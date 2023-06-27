package com.toy.jwtJpa.model.repository;

import com.toy.jwtJpa.model.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    /**
     * 회원 저장
     */
    public Long save(Member member) {
        member.setUsed(1);
        em.persist(member);
        return member.getNo();
    }

    /**
     * 회원 번호로 회원 조회
     */
    public Member findOne(Long no) {
        return em.find(Member.class, no);
    }

    /**
     * 회원 이름으로 회원 한 명 조회
     */
    public Member findOneByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    /**
     * 이메일로 회원 조회
     */
    public Member findOneByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * 회원 목록 조회
     */
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /**
     * 이름이 들어있는 회원 목록 조회
     */
    public List<Member> findByNameContaining(String name) {
        return em.createQuery("select m from Member m where m.name like :name", Member.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    /**
     * 회원정보 수정
     */
    public void update(Member member) {
        em.createQuery("update Member m set password = :password, name = :name, email = :email where no = :no")
                .setParameter("password", member.getPassword())
                .setParameter("name", member.getName())
                .setParameter("email", member.getEmail())
                .setParameter("no", member.getNo())
                .executeUpdate();
    }

    /**
     * 회원 비활성화
     */
    public void unUsed(Long no) {
        Member member = findOne(no);
        member.setUsed(0);
    }
}
