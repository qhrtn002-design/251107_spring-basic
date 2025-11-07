package kr.java.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // @Bean
public class LifecycleBean {
    // 스프링은 Bean으로 등록된 객체를 생성부터 종료까지 관리한다
    // - Servlet의 생명주기 유사
    // - React Class Component / Vue -> 생명주기
    @PostConstruct
    public void init() {
        // 생성자 = Constructor
        System.out.println("LifecycleBean.init");
    }

    @PreDestroy
    public void destroy() {
        // 소멸자 = Destructor
        System.out.println("LifecycleBean.destroy");
    }
}