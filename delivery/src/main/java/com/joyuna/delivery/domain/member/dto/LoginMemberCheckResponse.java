package com.joyuna.delivery.domain.member.dto;

import com.joyuna.delivery.domain.member.Member;
import lombok.Getter;

@Getter
public class LoginMemberCheckResponse {

    private final String loginId;
    private final String name;


    public LoginMemberCheckResponse(Member loginMember) {
        this.loginId = loginMember.getLoginId();
        this.name = loginMember.getName();
    }
}

