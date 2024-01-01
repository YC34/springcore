//package hello.core.beanfind;
//
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.env.Environment;
//
//
///**
// * Environment 인터페이스로 application.yml에 있는 정보 불러오기.
// */
//@SpringBootTest
//public class test {
//
//    @Autowired
//    private  Environment environment ;
//
//
//    @Test
//    @DisplayName("application.yml 파일 불러와보기")
//    void applicationYml(){
//        String property = environment.getProperty("test.key");
//        System.out.println("property = " + property);
//
//    }
//
//
//
//}
//
