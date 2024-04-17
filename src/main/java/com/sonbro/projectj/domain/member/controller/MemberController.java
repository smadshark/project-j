package com.sonbro.projectj.domain.member.controller;

import com.sonbro.projectj.domain.member.dao.Member;
import com.sonbro.projectj.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
