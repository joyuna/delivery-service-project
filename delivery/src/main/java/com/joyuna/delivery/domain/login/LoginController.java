package com.joyuna.delivery.domain.login;

import com.joyuna.delivery.domain.login.dto.LoginRequest;
import com.joyuna.delivery.domain.member.dto.LoginMemberCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginMemberCheckResponse> login(@Valid LoginRequest request, BindingResult bindingResult,
                                               HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("입력한 정보를 확인해주세요.");
        }
        LoginMemberCheckResponse loginMember = loginService.login(request);

        if (loginMember == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return ResponseEntity.ok().body(loginMember);
    }
}