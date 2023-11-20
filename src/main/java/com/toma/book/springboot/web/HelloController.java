package com.toma.book.springboot.web;

import com.toma.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환한느 컨트롤러로 만들어줌 / 예전 @ResponseBody 각 메서드 선언
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get의 요청을 받을 수 있는 API 만들어 줌 / 예전 @RequestMapping(method=RequestMethod.GET) / 이 프로젝트는 /hello로 요청이 오면 문자열 hello 반환하는 기능
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //@RequestParam
        // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        // 여기서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됨
        return new HelloResponseDto(name, amount);
    }
}
