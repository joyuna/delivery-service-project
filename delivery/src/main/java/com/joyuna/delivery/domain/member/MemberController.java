package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.member.dto.*;
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

    @PatchMapping("/{id}")
    public ResponseEntity<MemberUpdateResponse> updateById(@RequestBody MemberUpdateRequest memberUpdateRequest) {
        return ResponseEntity.ok().body(memberService.update(memberUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public void changeToDelete(@RequestBody MemberDeleteRequest request) {
        memberService.changeToDelete(request);
    }
}
