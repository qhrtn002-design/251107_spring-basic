package kr.java.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // 호출을 할 때 꺼내주는 Bean.
public class ProtypeBean {
    public ProtypeBean() {
        System.out.println("ProtypeBean.ProtypeBean");
    }
}