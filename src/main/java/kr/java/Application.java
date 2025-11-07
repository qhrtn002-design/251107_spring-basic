package kr.java;

import kr.java.biz.BizService;
import kr.java.scope.ProtypeBean;
import kr.java.scope.SingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class Application {
    public static void main(String[] args) {
        // Spring IoC Container -> 관리해주는 '맥락' 만들기
//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        ctx.close();
        // twr
        // 개발자가 직접 new로 생성자를 만든 적이 있는가?
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // 알아서 Config를 읽어서 bean 생성 -> '등록'
            // 등록된 Bean -> Context (container)
            System.out.println("[실제 로직]");
            MessageService service = ctx.getBean(MessageService.class); // 특정 클래스로 등록된 객체를 '꺼내서' 쓴다
            // 생성 및 생성 관련해서 필요한 매개변수(인자)를 알아서 다 스프링 컨테이너가 관리
            BizService service2 = ctx.getBean(BizService.class);
            service2.biz();
            service.show();
            System.out.println("[Scope]");
            SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
            ProtypeBean protypeBean1 = ctx.getBean(ProtypeBean.class);
            System.out.println(System.identityHashCode(singletonBean1));
            System.out.println(System.identityHashCode(protypeBean1));
            SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
            ProtypeBean protypeBean2 = ctx.getBean(ProtypeBean.class); // Protype은 각각 생성자가 호출
            System.out.println(System.identityHashCode(singletonBean2)); // 주소값도 Singleton은 같고
            System.out.println(System.identityHashCode(protypeBean2)); // Prototype은 다름
        }
        System.out.println("[컨테이너 종료됨]");
    }
}

@Configuration
@ComponentScan(basePackages = "kr.java.*")
//@ComponentScan(basePackages = {"kr.java.biz", "kr.java.scope"})
class AppConfig { // Spring <- 농부. 콩 심는 농부
    // Bean.
    @Bean
    public MessageService messageService(MessageUtil messageUtil) {
        return new MessageService(messageUtil); // 매개변수에 인자로 MessageUtil
        // ?
    }
    @Bean
    public MessageUtil messageUtil() {
        return new MessageUtil();
    }
}

class MessageService {
    private final MessageUtil messageUtil;

    // 생성자 주입 <- Bean으로 등록되어 있는 클래스로 만들어진 객체를 자동으로 집어넣어주는 것
    public MessageService(MessageUtil messageUtil) { // 생성자의 매개변수로 주입
        System.out.println("MessageService.MessageService");
        this.messageUtil = messageUtil;
    }

    public void show() {
        messageUtil.show();
    }
}

class MessageUtil {
    public MessageUtil() {
        System.out.println("MessageUtil.MessageUtil");
    }

    public void show() {
        System.out.println("MessageUtil로 메세지 출력");
    }
}