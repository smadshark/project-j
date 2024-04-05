package com.sonbro.projectj.repository;

import com.sonbro.projectj.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
