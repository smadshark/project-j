package com.sonbro.projectj.domain.member.repository;

import com.sonbro.projectj.domain.member.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByName(String name);
}
