package com.toma.book.springboot.web;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class) // 테스트 진행시, JUnit에 내장된 실행자 외 다른 실행자 실행 / 여기서는 SpringRunner라는 스프링 실행자 사용 / 스프링 부트 테스트와 JUnit 사이에 연결자 역할
// gradle5 부터 생략(강제로 생략)
@WebMvcTest(controllers = HelloController.class) // 여러 스프링 어노테이션 중 ,Web(Spring MVC)에 집중할 수 있는 어노테이션션 / @Controller, @ControllerAdvice 등을 사용할 수 있음 / @Service, @Component, @Repositiry 등은 사용할 수 없음 / 여기서는 컨트롤러만 사용하기 때문에 선언
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입 받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용 / 스프링 MVC 테스트의 시작점 / 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
        //mvc.perform(get("/hello"))
        // MockMvc를 통해 /hello 주소로 HTTP GET 요청
        // 체이닝 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있음
        //.andExpect(status().idOk())
        // mvc.perform의 결과 검증
        // HTTP Header의 Status를 검증
        // 우리가 흔히 알고 있는 200, 404, 500등의 상태 검증
        // 여기선 OK 즉, 200 여부 검증
        //.andExpect(content().string(hello))
        // mvc.perform의 결과 검증
        // 응답 본문의 내용 검증
        // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto").param("name", name).param("amount", String.valueOf(amount))).andExpect(status().isOk()).andExpect(jsonPath("$.name", is(name))).andExpect(jsonPath("$.amount", is(amount)));
        //param
        // API 테스트할 때 사용될 요청 파라미터 설정
        // 단, 값은 String만 허용
        // 그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야 가능
        //jsonPath
        // JSON 응답값을 필드별로 검증할 수 있는 메소드
        // $를 기준으로 필드명 명시
        // 여기서는 namer과 amount를 검증하니 $.name, $.amount로 검증
    }
}
