package com.joyuna.delivery.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberDeleteRequest {
    private Long id;
    private String loginId;
    private String loginPw;
}
