package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.login.dto.LoginMemberCheckRequest;
import com.joyuna.delivery.domain.member.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberCreateResponse createMember(MemberCreateRequest request) {
        checkDuplicateLoginId(request.getLoginId());
        Member member = memberRepository.save(request.toEntity());
        return new MemberCreateResponse(member);
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse getOne(long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + id));
        return new MemberInfoResponse(member);
    }

    @Transactional
    public MemberUpdateResponse updateMember(MemberUpdateRequest request) {
        Member member = memberRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + request.getId()));
        member.updateMember(request);
        return new MemberUpdateResponse(member);
    }

    @Transactional
    public void changeToDelete(MemberDeleteRequest request) {
        Member member = memberRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("조회 결과 없음 : " + request.getId()));
        member.changeToDelete();
    }

    @Transactional
    public void checkDuplicateLoginId(String loginId) {
        if (memberRepository.existsByLoginId(loginId)) {
            throw new IllegalArgumentException(loginId + "는 이미 사용 중인 아이디입니다.");
        }
    }

    @Transactional
    public LoginMemberCheckResponse getExistingMember(LoginMemberCheckRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("요청값이 없습니다.");
        }

        Member loginMember = memberRepository.findByLoginIdAndLoginPw(request.getLoginId(), request.getLoginPw())
                .orElseThrow(() -> new IllegalArgumentException("아이디와 비밀번호를 다시 확인해주세요."));

        return new LoginMemberCheckResponse(loginMember);
    }
}