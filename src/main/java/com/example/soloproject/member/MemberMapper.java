package com.example.soloproject.member;

import com.example.soloproject.member.Dto.MemberDto;
import com.example.soloproject.member.Dto.MemberPostDto;
import com.example.soloproject.member.Dto.MemberResponseDto;
import com.example.soloproject.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.validation.Valid;
import java.util.List;


//DTO 클래스를 변환하는 매퍼(Mapper)를 자동으로 생성하기 위해서는 매퍼(Mapper) 인터페이스를 먼저 정의해야 합니다.

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
//componentModel = "spring"을 지정해주면 Spring의 Bean으로 등록이 된다
public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post requestBody);
    MemberResponseDto memberToMemberResponseDto(Member member);

    MemberDto.response memberToMemberResponse(Member member);



    List<MemberDto.response> membersToMemberResponses(List<Member> members);



}
