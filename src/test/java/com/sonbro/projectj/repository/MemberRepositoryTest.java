package com.sonbro.projectj.repository;

import com.sonbro.projectj.domain.member.dao.Member;
import com.sonbro.projectj.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-member.sql")
    @Test
    void getAllMembers() {
        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-member.sql")
    @Test
    void getMemberById() {
        // when
        Member member = memberRepository.findById(2L).get();

        // then
        assertThat(member.getName()).isEqualTo("park");
    }

    @Sql("/insert-member.sql")
    @Test
    void getMemberByName() {
        // when
        Member member = memberRepository.findMemberByName("kim").get();

        // then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember() {
        // given
        Member saveMember = new Member(1L, "jack");

        memberRepository.save(saveMember);

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("jack");
    }

    @Test
    void saveMembers() {
        // given
        List<Member> members = List.of(
                new Member(2L, "hook"),
                new Member(3L, "petter")
        );

        // when
        memberRepository.saveAll(members);

        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-member.sql")
    @Test
    void deleteMemberById() {
        // when
        memberRepository.deleteById(2L);

        // then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/insert-member.sql")
    @Test
    void deleteAll() {
        // when
        memberRepository.deleteAll();

        // then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-member.sql")
    @Test
    void update() {
        // given
        Member member = memberRepository.findById(2L).get();

        // when
        member.setName("BC");

        // then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
}