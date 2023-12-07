package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
        return ResponseEntity.ok().body(memberService.createMember(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoResponse> getOne(@PathVariable long id) {
        return ResponseEntity.ok().body(memberService.getOne(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberUpdateResponse> updateMember(@RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok().body(memberService.updateMember(request));
    }

    @DeleteMapping("/{id}")
    public void changeToDelete(@RequestBody MemberDeleteRequest request) {
        memberService.changeToDelete(request);
    }
}
