package com.example.soloproject.member.Controller;

import com.example.soloproject.Dto1.SingleResponseDto;
import com.example.soloproject.member.Dto.MemberDto;
import com.example.soloproject.member.Dto.MemberPostDto;
import com.example.soloproject.member.Dto.MemberResponseDto;
import com.example.soloproject.member.MemberMapper;
import com.example.soloproject.member.entity.Member;
import com.example.soloproject.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/member")
@Slf4j
@Validated
// 검증이 정상적으로 수행되려면 클래스 레벨에 @Validated 애너테이션을 반드시 붙여주어야 한다는 사실을 기억하기 바랍니다.
public class MemberController {

    private final MemberService memberService;

    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper){
        this.memberService = memberService;
        this.mapper = mapper;
    }

    //회원 추가
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody ){
        //DTO 클래스에서 유효성 검증 로직이 실행되게 하기 위해서,@Valid 애너테이션을 추가
        Member member = mapper.memberPostToMember(requestBody);
        Member createdMember = memberService.createMember(member);
//        Member member =
//                memberService.createMember(mapper.memberPostDtoToMember(memberDto));
//
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)),HttpStatus.CREATED);

        // (2) 매퍼를 이용해서 MemberPostDto를 Member로 변환
//                Member member = mapper.memberPostToMember(createdMember);
//
//                Member response = memberService.createMember(member);
//
//        				// (3) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
//                return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
//                        HttpStatus.CREATED);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponse(createdMember)),
                HttpStatus.CREATED);
            }




    //한명 회원 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId){

        Member response = memberService.findMember(memberId);


        return new ResponseEntity<>((mapper.memberToMemberResponseDto(response))
                , HttpStatus.OK);
    }

    //모든 회원 조회
    @GetMapping
    public ResponseEntity getMembers(){


        return new ResponseEntity<>(mapper, HttpStatus.OK);

        //Member list = memberService.findMembers();

//        return new ResponseEntity<>((mapper.membersToMemberResponseDtos(members),
//                        pageMembers),
//                HttpStatus.OK);
    }
    //memberService.findMembers()를 통해 리턴되는 값이 List 이므로 List 안의 Member 객체들을 하나씩 꺼내어서 MemberResponseDto 객체로 변환해주어야 하는데, 이 작업은 Java의 Stream이 해주고 있습니다.

//    @GetMapping("/location")
//    public ResponseEntity getLocation(@PathVariable("location") String location){
//
//    }
//
//    @GetMapping("/type")
//    public ResponseEntity getType(@PathVariable("type") String type ){
//
//    }

}



