package com.shop.service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
// 생성자를 자동으로 생성
@RequiredArgsConstructor
public class MemberService {
    // final이 꼭 필요
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        // 이메일로 가입 중복 체크
        validateDuplicateMember(member);
        // 가입이 되어 있지 않으면 db에 저장
        return memberRepository.save(member);
    }
    // 중복 체크 이메일로 확인
    private void validateDuplicateMember(Member member) {
        // 쿼리문을 날림
        Member findMember = memberRepository.findByEmail(member.getEmail());
        // 객체에 값이 있으면 가입된 회원임
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원 입니다.");
        }
    }

}
