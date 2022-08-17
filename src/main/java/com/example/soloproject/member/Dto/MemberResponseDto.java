package com.example.soloproject.member.Dto;

import com.example.soloproject.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;
    private String name;
    private String password;
    private String sex;
    private String company_name;

//    private Member.MemberStatus memberStatus;
//
//    public String getMemberStatus() {
//        return memberStatus.getStatus();
//    }


}
