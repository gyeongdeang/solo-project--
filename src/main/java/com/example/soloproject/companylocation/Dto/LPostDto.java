package com.example.soloproject.companylocation.Dto;

import javax.validation.constraints.NotBlank;

public class LPostDto {

    @NotBlank(message = "지역명은 공백이 아니어야 합니다.")
    private String location;


}
