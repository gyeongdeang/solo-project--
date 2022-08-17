package com.example.soloproject.companylocation.entity;

import com.example.soloproject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOCATION")
public class CompanyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyLocationId;

    @Column(length = 100, nullable = false)
    private String location;


    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private CompanyLocationStatus orderStatus = CompanyLocationStatus.ORDER_REQUEST;

    public enum CompanyLocationStatus {
        ORDER_REQUEST(1, "서울"),
        ORDER_CONFIRM(2, "인천"),
        ORDER_COMPLETE(3, "수원"),
        ORDER_CANCEL(4, "화성");
        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        CompanyLocationStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
//        @Getter
//        private String status;
//
//        CompanyLocationStatus(String status) {
//            this.status = status;
//        }

        //@ManyToOne
        @OneToOne// (1)
        @JoinColumn(name = "MEMBER")  // (2)
        private Member member;

        public void addMember(Member member) {
            this.member = member;
        }


    }
}
