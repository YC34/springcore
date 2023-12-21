package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 Bean 출력하기")
    void findAllBean(){
        int beanDefinitionCount = ac.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount = " + beanDefinitionCount);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name =" + beanDefinitionName + "bean = " + bean);
        }


    }


    @Test
    @DisplayName("Application bean 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // bean의 정보들

            // 내가 등록한 bean만 조회하기
            // BeanDefinition.ROLE_APPLICATION : 내가 등록한 bena
            // BeanDefinition.ROLE_APPLICA : spring이 자동으로 등록한 bean
            if(beanDefinition.getRole()==BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "  bean = " + bean);
            }
        }


    }
}
