package kr.java.biz;

import org.springframework.stereotype.Component;

@Component
public class BizService {
    private final BizUtil bizUtil;

    public BizService(BizUtil bizUtil) {
        this.bizUtil = bizUtil;
        System.out.println("BizService.BizService");
    }

    public void biz() {
        bizUtil.biz();
    }
}