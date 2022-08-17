package com.example.soloproject.companytype.Dto;

import javax.validation.constraints.NotBlank;

public class TypePostDto {

    @NotBlank(message = "사업타입은 공백이 아니어야 합니다.")

    private String workType;

    public String getWorkType() {
        return workType;
    }

//    public void setWorkType(String workType) {
//        this.workType = workType;
//    }
}
