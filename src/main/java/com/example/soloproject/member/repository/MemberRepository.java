package com.example.soloproject.member.repository;

import com.example.soloproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>  {
    //CrudRepository 인터페이스를 통해서 편리하게 데이터를 데이터베이스의 테이블에 저장, 조회, 수정, 삭제할 수 있습니다.
        //CrudRepository<Member, Long> 에서 Member는 Member 엔티티 클래스를 가르키며,
        // Long은 Member 엔티티 클래스에서 @Id 애너테이션이 붙은 멤버 변수의 타입을 가르킵니다.
    //-- JDBC-> CrudRepository 인터페이스 제공
    //-- JPA -> JpaRepository 인터페이스 제공

    Member save(Member member);
   // Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    //쿼리 메서드는 이미 테이블에 등록된 이메일 주소가 있는지 확인하기 위한 용도로 사용
    //Spring Data JDBC에서는 Optional을 지원하기 때문에 리턴값을 Optional로 래핑할 수 있다는 사실을 기억하길 바랍니다.


    @Query(value = "SELECT c FROM MEMBER c WHERE c.memberId = :memberId")  // (2-3)
   Optional<Member> findById(long id);
}
