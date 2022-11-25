package com.shop.controller;

import com.shop.dto.MemberFromDto;
import com.shop.entity.Member;
import com.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/new")
    public String memberForm(Model model){
        // 타임리프에서 만들어서 dto로 넘겨줌
        model.addAttribute("memberFormDto", new MemberFromDto());
        return "member/memberForm"; // 회원가입 페이지를 불러옴
    }
    // submit 클릭 후 dto에 input값을 가져와서 dto값을 db에 저장
    @PostMapping("/new")
    public String memberForm(MemberFromDto memberFromDto){
        Member member = Member.createMember(memberFromDto, passwordEncoder);
        memberService.saveMember(member);
        // 회원 가입 후 로그인(root페이지)로 이동, redirect:/ - root로 경로를 바꾸는 것
        return "redirect:/";
    }
}
