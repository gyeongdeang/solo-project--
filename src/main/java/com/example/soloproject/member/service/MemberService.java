package com.example.soloproject.member.service;

import com.example.soloproject.advice.BusinessLogicException;
import com.example.soloproject.advice.ExceptionCode;
import com.example.soloproject.member.entity.Member;
import com.example.soloproject.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        Member createdMember = member;
        return createdMember;
    }

// //return memberRepository.save(member);
//        //Member findMember = findVerifiedMember(member.getMemberId());
    //  public Member findMember(long memberId) {
    //
    //        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    //
    //    } -- 예외처리

    // (7) 특정 회원 정보 조회
    public Member findMember(long memberId) {

     return findVerifiedMember(memberId);

//        Member member =
//                new Member(memberId, "김코딩", "s4goodbye!", "M", "프로젝트스테이츠" );
//        return member;

    }

   //  (8) 모든 회원 정보 조회

    public List<Member> findMembers() {

        List<Member> members = List.of(
                new Member(1L, "김코딩", "s4goodbye!","M","프로젝트스테이츠"),
                new Member(2L, "김토끼", "v3425!@", "F","화이트체이트스")
        );

        return members;}
//        return (List<Member>) memberRepository.findVerifiedMember();
//    }

//    public List<Member> findMembersAll(String location ,String type){
//
//        return ;
//    }



    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }
        //이미 존재하는 회원인지를 검증한 후, 검증된 회원 정보를 리턴해주는 기능을 합니다.
    //optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)); 에서
    // orElseThorow()는 optionalMember 객체가 null 이 아니라면 해당 객체를 리턴하고 null이라면 예외를 던집니다.

    }
