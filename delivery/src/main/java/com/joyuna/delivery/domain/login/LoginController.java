package com.joyuna.delivery.domain.login;

import com.joyuna.delivery.domain.login.dto.LoginRequest;
import com.joyuna.delivery.domain.member.dto.LoginMemberCheckResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginMemberCheckResponse> login(@Valid @RequestBody LoginRequest request, BindingResult bindingResult,
                                                          HttpServletRequest httpServletRequest) {
        log.info("ID : " + request.getLoginId() + ", PW : " + request.getLoginPw());

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("입력한 정보를 확인해주세요.");
        }

        LoginMemberCheckResponse loginMember = loginService.login(request);

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return ResponseEntity.ok().body(loginMember);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}