package com.joyuna.delivery.domain.member.dto;

import com.joyuna.delivery.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberInfoResponse {
    private final String name;
    private final String loginId;
    private final String email;
    private final String tel;

    public MemberInfoResponse(Member member) {
        this.name = member.getName();
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.tel = member.getTel();
    }
}
