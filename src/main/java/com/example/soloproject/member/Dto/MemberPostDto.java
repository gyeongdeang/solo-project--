package com.example.soloproject.member.Dto;

import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public class MemberPostDto { // 회원정보등록
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String name;

    @NotBlank(message = "성별은 공백이 아니어야 합니다.")
    private String password;

    @NotBlank(message = "성별은 공백이 아니어야 합니다.")
    private String sex;

    @NotBlank(message = "회사이름은 공백이 아니어야 합니다.")
    private String companyName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getCompanyName() {
        return companyName;
    }
}



