package com.example.member.service;

import com.example.member.dto.*;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {
        Member member = new Member(request.getName());
        Member savedMember = memberRepository.save(member);
        return new CreateMemberResponse(
                savedMember.getId(),
                savedMember.getName()
        );
    }

    @Transactional(readOnly = true)
    public GetMemberResponse findOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 맴버입니다.")
        );
        return new GetMemberResponse(
                member.getId(),
                member.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();

        List<GetMemberResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(
                    new GetMemberResponse(
                            member.getId(),
                            member.getName()
                    )
            );
        }
        return dtos;
    }

    @Transactional
    public UpdateMemberResponse updatename(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 맴버입니다.")
        );

        member.updatename(request.getName());
        return new UpdateMemberResponse(
                member.getId(),
                member.getName()
        );
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);

        if (!existence) {
            throw new IllegalStateException("존재하지 않는 멤버입니다.");
        }

        memberRepository.deleteById(memberId);
    }
}
