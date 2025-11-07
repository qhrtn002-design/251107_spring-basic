package kr.java.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// singleton (1번 만들어놓고 계속 재활용) : 스프링 IoC 컨테이너당 1개 인스턴스.
// prototype (사용할 때마다 별도의 객체를 만듦) : getBean() 호출 시에 객체를 생성
// -------
// Web 환경 -> 만들고 그런 개념은 아님. Spring Web MVC가 알아서 해준다
// request (요청)
// session (세션)
// application (애플리케이션)
@Component
@Scope("singleton") // 기본 세팅
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean.SingletonBean");
    }
}