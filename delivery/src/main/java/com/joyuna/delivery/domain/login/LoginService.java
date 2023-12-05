package com.joyuna.delivery.domain.login;

import com.joyuna.delivery.domain.login.dto.LoginMemberCheckRequest;
import com.joyuna.delivery.domain.login.dto.LoginRequest;
import com.joyuna.delivery.domain.member.MemberService;
import com.joyuna.delivery.domain.member.dto.LoginMemberCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;

    public LoginMemberCheckResponse login(final LoginRequest request) {
        LoginMemberCheckRequest loginMemberCheckRequest = new LoginMemberCheckRequest(request.getLoginId(), request.getLoginPw());
        return memberService.getExistingMember(loginMemberCheckRequest);
    }
}
