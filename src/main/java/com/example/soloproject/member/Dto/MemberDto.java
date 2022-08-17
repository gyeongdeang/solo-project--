package com.example.soloproject.member.Dto;

import com.example.soloproject.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


public class MemberDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String name;

        @NotBlank(message = "성별은 공백이 아니어야 합니다.")
        private String password;

        @NotBlank(message = "성별은 공백이 아니어야 합니다.")
        private String sex;

        @NotBlank(message = "회사이름은 공백이 아니어야 합니다.")
        private String companyName;
    }

    @AllArgsConstructor
    @Getter
    public static class response{
        private long memberId;
        private String name;
        private String password;
        private String sex;
        private String companyName;

       private Member.MemberStatus memberStatus;

        public String getMemberStatus() {
            return memberStatus.getStatus();
        }
    }
}
