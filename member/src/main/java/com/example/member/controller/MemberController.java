package com.example.member.controller;

import com.example.member.dto.*;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> createMember(@RequestBody CreateMemberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(request));
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<GetMemberResponse> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOne(memberId));
    }

    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<UpdateMemberResponse> updateMemberName(@PathVariable Long memberId, @RequestBody UpdateMemberRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updatename(memberId, request));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
