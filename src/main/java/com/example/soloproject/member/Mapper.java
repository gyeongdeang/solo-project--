//package com.example.soloproject.member;
//
//import com.example.soloproject.member.Dto.MemberDto;
//import com.example.soloproject.member.Dto.MemberPostDto;
//import com.example.soloproject.member.Dto.MemberResponseDto;
//import com.example.soloproject.member.entity.Member;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Mapper {
//    public Member MemberPostDtoToMember(MemberPostDto memberPostDto) {
//        return new Member(0L,
//                memberPostDto.getName(),
//                memberPostDto.getPassword(),
//                memberPostDto.getSex(),
//                memberPostDto.getCompanyName());
//    }
//    public MemberResponseDto memberToMemberResponseDto(Member member) {
//        return new MemberResponseDto(
//                member.getMemberId(),
//                member.getPassword(),
//                member.getName(),
//                member.getSex(),
//                member.getCompanyName()
//                );
//    }
//
//}
