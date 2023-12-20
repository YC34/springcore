package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixdiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 역할과 구현에 대한 명확성
 */

@Configuration // step 06
public class AppConfig { //step 03


    // MemberService에 대한 config
    // 구현 객체는 MemeberServiceImpl을 사용 하겟다.
    // 어떤 저장소를 사용할래? memberRepository를 사용할래


    @Bean   // step 06
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //step 03
    }


    // MemberRepository config
    // 구현 객체는 MemoryMemberRepository
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    } // step 04


    // OrderService config
    // 구현 객체는 OrderServiceImpl
    // 구현 객체에서 사용해줄 객체는?
    // memberRepository와 discountPolicy를 사용할래.
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    //  DiscountPolicy config
    // 구현 객체는 FixdiscountPolicy
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixdiscountPolicy();
        return new RateDiscountPolicy(); // step 05 할인에 대한 정책을 변경할 시 이 부분만 변경해주면 된다.
    }


}
