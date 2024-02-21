package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 구성 정보
public class AppConfig {  // 애플리케이션에 대한 환경 구성에 대한 건 AppConfig에서 한다.

//    public MemberService memberService() {  // AppConfig을 통해서 MemberService를 사용한다.
//        return new MemberServiceImpl(new MemoryMemberRepository());  // 생성자 주입
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    @Bean
    public MemberService memberService() {  // 멤버서비스 역할
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {  // 멤버리포지토리 역할
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {  // 주문서비스 역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {  // 할인정책 역할
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
