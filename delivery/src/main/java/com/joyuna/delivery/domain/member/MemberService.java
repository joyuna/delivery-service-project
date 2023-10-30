package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.MemberResponseDto;
import com.joyuna.delivery.domain.member.dto.MemberCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberResponseDto save(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.save(memberCreateRequest.toEntity());
        return new MemberResponseDto(member);
    }
}
