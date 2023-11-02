package com.joyuna.delivery.domain.member.dto;

import com.joyuna.delivery.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberInfoResponse {
    private String name;
    private String loginId;
    private String email;
    private String tel;

    public MemberInfoResponse(Member member) {
        this.name = member.getName();
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.tel = member.getTel();
    }
}
