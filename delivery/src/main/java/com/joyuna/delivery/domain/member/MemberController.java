package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.MemberCreateRequest;
import com.joyuna.delivery.domain.member.dto.MemberCreatedResponse;
import com.joyuna.delivery.domain.member.dto.MemberInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberCreatedResponse> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return ResponseEntity.ok().body(memberService.save(memberCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoResponse> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(memberService.findById(id));
    }
}
