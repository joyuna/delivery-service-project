package com.joyuna.delivery.domain.member.dto;

import com.joyuna.delivery.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberCreateRequest {
    private String name;
    private String loginId;
    private String loginPw;
    private String email;
    private String tel;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .loginId(loginId)
                .loginPw(loginPw)
                .email(email)
                .tel(tel)
                .build();
    }
}
