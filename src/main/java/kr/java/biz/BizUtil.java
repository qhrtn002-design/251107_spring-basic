package kr.java.biz;

import org.springframework.stereotype.Component;

@Component // Bean인데 직접 생성자를 Config에 등록하는게 아니라, 넣어주면 알아서 생성자화 시켜주는 대상
public class BizUtil {
    public BizUtil() {
        System.out.println("BizUtil.BizUtil");
    }

    public void biz() {
        System.out.println("BizUtil.biz");
    }
}