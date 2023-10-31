package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.MemberCreatedResponse;
import com.joyuna.delivery.domain.member.dto.MemberCreateRequest;
import com.joyuna.delivery.domain.member.dto.MemberInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberCreatedResponse save(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.save(memberCreateRequest.toEntity());
        return new MemberCreatedResponse(member);
    }

    public MemberInfoResponse findById(long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        return new MemberInfoResponse(member);
    }
}
