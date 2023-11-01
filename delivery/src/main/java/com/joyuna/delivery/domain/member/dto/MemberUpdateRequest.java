package com.joyuna.delivery.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {
    private Long id;
    private String name;
    private String loginPw;
    private String email;
    private String tel;
}
