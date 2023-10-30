package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.MemberCreateRequest;
import com.joyuna.delivery.domain.member.dto.MemberResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return ResponseEntity.ok().body(memberService.save(memberCreateRequest));
    }
}
