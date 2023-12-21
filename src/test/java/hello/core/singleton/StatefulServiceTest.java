package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        // 1. 객체 생성
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        // 2. 조회
//        service1.order("memberA",10000);
//        service2.order("memberB",20000);
//
//        int price = service1.getPrice();
//        // memberA의 가격이 나와야함. 하지만 객체를 공유하므로,
//        // getPrice를 하기전에 다른 객체가 공유 되어서 memberB의 price가 출력된다.
//
//        System.out.println("price = " + price);

        int memberA = service1.order("memberA", 10000);
        int memberB = service2.order("memberB", 20000);

        System.out.println("memberA  pricce = " + memberA);
    }

    static class TestConfig{


        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}