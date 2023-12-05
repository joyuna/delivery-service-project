package com.joyuna.delivery.domain.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginMemberCheckRequest {
    private String loginId;
    private String loginPw;
}
