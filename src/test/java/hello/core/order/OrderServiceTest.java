package hello.core.order;


import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();

    @Test
    void order() {

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        //TODO
        // member 객체가 안넘어가는 문제 찾기.
        // member를 put하는 과정에서 static으로 map을 지정하지 않아 . 접근을 못햇음..?
        Order order = orderService.createOrder(memberId, "testA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}
