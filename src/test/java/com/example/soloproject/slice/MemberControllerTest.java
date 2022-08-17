//package com.example.soloproject.slice;
//
//import com.example.soloproject.helper.MemberControllerTestHelper;
//import com.example.soloproject.member.Dto.MemberDto;
//import com.example.soloproject.member.MemberMapper;
//import com.example.soloproject.member.entity.Member;
//import com.example.soloproject.member.service.MemberService;
//import com.google.gson.Gson;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpMethod;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@Transactional
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MemberControllerTest implements MemberControllerTestHelper {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @MockBean
//    private MemberService memberService;
//
//    @Autowired
//    private MemberMapper mapper;
//
//    private ResultActions postResultActions;
//    private MemberDto.Post post;
//    private MvcResult postResult;
//
//
////테스트 케이스를 실행하기 전에 어떤 객체나 값에 대한 초기화 작업 등의 전처리 과정
//    @BeforeEach
//    public void init() throws Exception {
//        this.post = (MemberDto.Post) StubData.MockMember.get(HttpMethod.POST);
//        String content = gson.toJson(post);
//        URI uri = getURI();
//        this.postResultActions = mockMvc.perform(postRequestBuilder(uri, content));
//    }
//
//    @Test
//    public void postMemberTest() throws Exception {
//        // given
//        MemberDto.Post post = new MemberDto.Post("김코딩","s4goodbye!","m","프로젝트스테이츠");
//
//
//        Member member = mapper.memberPostToMember(post);
//        // when
//        // init()
//
//        // then
//        MvcResult result =
//                this.postResultActions
//                        .andExpect(status().isCreated())
//                        .andExpect(jsonPath("$.data.name").value(this.post.getName()))
//                        .andExpect(jsonPath("$.data.password").value(this.post.getPassword()))
//                        .andExpect(jsonPath("$.data.sex").value(this.post.getSex()))
//                        .andExpect(jsonPath("$.data.companyName").value(this.post.getCompanyName()))
//                        .andReturn();
//
////        System.out.println(result.getResponse().getContentAsString());
//    }
//
//    @Test
//    void getMemberTest() throws Exception {
//        // given
//        // init()
//
//        // when
//        long memberId = getResponseMemberId();
//        URI uri = getURI(memberId);
//
//        // then
//        mockMvc.perform(getRequestBuilder(uri))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").value(this.post.getName()))
//                .andExpect(jsonPath("$.data.password").value(this.post.getPassword()))
//                .andExpect(jsonPath("$.data.sex").value(this.post.getSex()))
//                .andExpect(jsonPath("$.data.companyName").value(this.post.getCompanyName()));
//
//    @Test
//    void getMembersTest() throws Exception {
//        // given
//        String content = gson.toJson(new MemberDto.Post("김코딩",
//                "s4goodbye!",
//                "m",
//                "프로젝트스테이츠"));
//        URI uri = getURI();
//        mockMvc.perform(postRequestBuilder(uri, content));
//
//        // when
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", String.valueOf(1));
//        queryParams.add("size", String.valueOf(10));
//
//        // then
//        MvcResult result = mockMvc.perform(getRequestBuilder(uri, queryParams))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andReturn();
//        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
//
//        assertThat(list.size(), is(2));
//    }
//
//
//    private long getResponseMemberId() {
//        long memberId;
//        try {
//            String responseMember = this.postResultActions
//                    .andReturn()
//                    .getResponse()
//                    .getContentAsString();
//            memberId = JsonPath.parse(responseMember).read("$.data.memberId", Long.class);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//
//        return memberId;
//    }
//}


