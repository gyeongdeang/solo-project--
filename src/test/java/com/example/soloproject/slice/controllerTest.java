package com.example.soloproject.slice;

import com.example.soloproject.helper.MemberControllerTestHelper;
import com.example.soloproject.member.Dto.MemberDto;
import com.example.soloproject.member.MemberMapper;
import com.example.soloproject.member.entity.Member;
import com.example.soloproject.member.service.MemberService;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class controllerTest implements MemberControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;
    // Gson이라는 JSON 변환 라이브러리

    @MockBean
    private MemberService memberService;

    @Autowired
    private MemberMapper mapper;

    private ResultActions postResultActions;
    private MemberDto.Post post;

//// given (5) 테스트용 request body 생성
//
//        // when (6) MockMvc 객체로 테스트 대상 Controller 호출
//
//        // then (7) Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
    @Test
    public void postMemberTest() throws Exception{

        //given
        //테스트를 위한 준비 과정을 명시할 수 있습니다.
        //테스트에 필요한 전제 조건들이 포함된다고 보면 됩니다.
        //테스트 대상에 전달되는 입력 값(테스트 데이터) 역시 Given에 포함됩니다

        MemberDto.Post post = new MemberDto.Post("김코딩",
                "s4goodbye!",
                "m",
                "프로젝트스테이츠");

        MemberDto.response responseDto =
                new MemberDto.response(1L,
                        "김코딩",
                        "s4goodbye!",
                        "M",
                        "프로젝트스테이츠",
                        Member.MemberStatus.MEMBER_ACTIVE);


        Member member = mapper.memberPostToMember(post);

        given(memberService.createMember(Mockito.any(Member.class)))
                .willReturn(member);

        String content = gson.toJson(post);

        //MockMemberService(가칭)의 createMember() 메서드가 리턴 할 Stub 데이터

        //When
        //테스트 할 동작(대상)을 지정합니다.
        //단위 테스트에서는 일반적으로 메서드 호출을 통해 테스트를 진행하므로 한두줄 정도로 작성이 끝나는 부분입니다.

        ResultActions actions =
                mockMvc.perform(
                        post("/v1/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
    //perform() 메서드 내부에 Controller 호출을 위한 세부적인 정보들이 포함

        // then
        MvcResult result = actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.name").value(this.post.getName()))
                .andExpect(jsonPath("$.data.password").value(this.post.getPassword()))
                .andExpect(jsonPath("$.data.sex").value(this.post.getSex()))
                .andExpect(jsonPath("$.data.companyName").value(this.post.getCompanyName()))
                .andReturn();

        //then
        //테스트의 결과를 검증하는 영역입니다.
        //일반적으로 예상하는 값(expected)과 테스트 대상 메서드의 동작 수행 결과(actual) 값을 비교해서 기대한대로 동작을 수행하는지 검증(Assertion)하는 코드들이 포함됩니다.
        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    void getMemberTest() throws Exception {
        // given


        // when
        long memberId = getResponseMemberId();
        URI uri = getURI(memberId);

        // then
        mockMvc.perform(getRequestBuilder(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(this.post.getName()))
                .andExpect(jsonPath("$.data.password").value(this.post.getPassword()))
                .andExpect(jsonPath("$.data.sex").value(this.post.getSex()))
                .andExpect(jsonPath("$.data.companyName").value(this.post.getCompanyName()));

    }

    @Test
    void getMembersTest() throws Exception {
        // given
        String content = gson.toJson(new MemberDto.Post("김코딩",
                "s4goodbye!",
                "m",
                "프로젝트스테이츠"));
        URI uri = getURI();
        mockMvc.perform(postRequestBuilder(uri, content));

        // when
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", String.valueOf(1));
        queryParams.add("size", String.valueOf(10));

        // then
        MvcResult result = mockMvc.perform(getRequestBuilder(uri, queryParams))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andReturn();
        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertThat(list.size(), is(2));
    }


        private long getResponseMemberId() {
            long memberId;
            try {
                String responseMember = this.postResultActions
                        .andReturn()
                        .getResponse()
                        .getContentAsString();
                memberId = JsonPath.parse(responseMember).read("$.data.memberId", Long.class);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            return memberId;
        }

    }

