package com.toma.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    // 프로젝트의 메인 클래스
    // @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야 함
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // SpringApplication.run으로 내장 WAS 실행
        // 내장 WAS : 별도로 외부에 WAS 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것
        // 이점 : 톰캣 설치할 필요 X, 스프링부트로 만들어진 Jar 파일로 싱행
        // 스프링부트에서는 내장 WAS 사용 권장(언제 어디서나 같은 환경에서 스프링 부트 배포)
    }
}
// 앞으로도 계속 테스트 코드 작성
// 브라우저로 한 번씩 검증은 하되, 테스트 코드는 똑 따라해야 함
// 그래야만 견고한 소프트웨어를 만드는 역량이 성장할 수 있음
// 추가로, 절대 수동으로 검증하고 테스트 코드를 작성하지 않기!!
// 테스트 코드로 먼저 검증 후, 정말 못 믿겠다 생각이 들 때 프로젝스틑 실행해 확인