package com.example.soloproject.member.entity;

import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.companytype.entity.CompanyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity //JPA에서 해당 클래스를 엔티티 클래스로 인식
@Table(name = "MEMBER")
public class Member {
    @Id //JPA에서 해당 클래스를 엔티티 클래스로 인식
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY 전략은 데이터베이스에서 기본키를 대신 생성해 준다
    // 식별자를 생성해주는 전략을 지정할 때 사용
    //(strategy = GenerationType.SEQUENCE) //SEQUENCE 전략은 데이터베이스 시퀀스를 이용
    //(strategy = GenerationType.AUTO)를 지정하면 JPA가 데이터베이스의 Dialect에 따라서 적절한 전략을 자동으로 선택
    private long memberId;


    public Member(Long memberId, @NotBlank(message = "이름은 공백이 아니어야 합니다.") String name, @NotBlank(message = "성별은 공백이 아니어야 합니다.") String password, @NotBlank(message = "성별은 공백이 아니어야 합니다.") String sex, @NotBlank(message = "회사이름은 공백이 아니어야 합니다.") String companyName) {
        this.memberId = memberId;
    }

    @Column(nullable = false, length = 100)
    private String name;

//    public Member(String name) {
//        this.name = name;
//    }

    @Column(nullable = false, length = 20, updatable = false, unique = true)
    private String password;


    private int type;
    private int location;

//    public Member(String password) {
//        this.password  = password;
//    }

    @Column(nullable = false, length = 2)
    private String sex;

//    public Member(String sex) {
//        this.sex = sex;
//    }

    @Column(nullable = false, length = 100, updatable = false, name = "Company_Name")
    private String companyName;



    //    public Member(String companyName) {
//        this.companyName = companyName;
//    }
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();   // 회원 정보가 등록 될 때의 시간 및 날짜를 매핑하기 위한 필드

    // (3)
    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, String password, String sex, String companyName) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.companyName = companyName;
    }



    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }





    @OneToOne(mappedBy = "member")
    private List<CompanyType> companyTypes = new ArrayList<>();

    public void addCompanyType(CompanyType companyType) {
        companyTypes.add(companyType);
    }

    @OneToOne(mappedBy = "member")
    private List<CompanyLocation> companyLocations = new ArrayList<>();

    public void addCompanyLocation(CompanyLocation companyLocation) {
        companyLocations.add(companyLocation);
    }

}



//    @ManyToOne
//    @JoinColumn(name = "COMPANY_TYPE_ID")
//    private CompanyType companyType;
//    @ManyToOne
//    @JoinColumn(name = "COMPANY_LOCATION_ID")
//    private CompanyLocation company_location;

//    @OneToMany(mappedBy = "member")
//    private CompanyType companyType;
//
//    public Member(String name){this.name = name;}
//
//    public Member(String name, String password,String sex,String companyName){
//        this.name =name;
//        this.password = password;
//        this.sex = sex;
//        this.companyName = companyName;
//    }
//
//    @OneToMany(mappedBy = "member")
//    private CompanyLocation companyLocation;
//

//
//    public Member(long memberId, String name, String password, String sex, String companyName) {
//    }

