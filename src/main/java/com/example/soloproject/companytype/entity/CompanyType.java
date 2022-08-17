package com.example.soloproject.companytype.entity;

import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;


import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TYPE")
public class CompanyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyTypeId;


    @Column(length = 100, nullable = false)
    private String workType;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private CompanyTypeStatus orderStatus = CompanyTypeStatus.ORDER_REQUEST;

    public enum CompanyTypeStatus {
        ORDER_REQUEST(1, "디자인"),
        ORDER_CONFIRM(2, "음식점"),
        ORDER_COMPLETE(3, "건설"),
        ORDER_CANCEL(4, "컴퓨터");
        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        CompanyTypeStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
//        @Getter
//        private String status;
//
//        CompanyTypeStatus(String status) {
//            this.status = status;
//        }

    }
    //@ManyToOne   // (1)
    @OneToOne
    @JoinColumn(name = "MEMBER")  // (2)
    private Member member;

    public void addMember(Member member) {
        this.member = member;
    }

}
