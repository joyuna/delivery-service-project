package com.joyuna.delivery.domain.login.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponse {
    private final String loginId;
    private final String name;
}
