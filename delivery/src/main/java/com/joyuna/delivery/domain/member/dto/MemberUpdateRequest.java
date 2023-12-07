package com.joyuna.delivery.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdateRequest {
    private Long id;
    private String name;
    private String loginPw;
    private String email;
    private String tel;
}
