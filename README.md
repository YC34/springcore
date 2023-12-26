# spring core study

### 참고 강의
inflearn 김영한 : spring 핵심 원리편

+ SOLID 원칙
+ 객체지향
+ 역할과 구현으로 구분


### 개발 환경 및 spring setting 정보

+ OS : mac m2
+ java version : 17
+ spring boot version : 3.2.0
+ packaging : JAR
+ dependency : boot-starter, boot-starter-test

### 메모


+ 도메인 협력 관계(유스케이스?) -> 클래스 다이어그램 -> 객체 다이어그램 
    > 클래스 다이어 그램은 실제로 구현한 모습이 아닌, 전체적인 클래스 다이어그램.
      객체 다이어 그램은 실제로 구현할 모습의 다이어그램. 요구사항을 정의 한 뒤, 유스케이스, 다이어그램을 그려 명확히 표현한다.
+ step 01의 문제점은 DIP를 위반 하고 있음. 인터페이스와 구현체 모두에게 의존하고 있음.
+ step 02에서도 여전히 인터페이스와 구현체 모두에게 의존하고 있음.(OCP 위반)
+ step 03 관심사 분리 : config파일 생성 -> application 전반에 대한 운영을 책임지는 파일 , 구현체는 의존관계는 신경쓰지 않고 실행에만 집중한다.
+ step 04 AppConfig 리펙토링 : 명확성을 위함.
+ step 05 AppConfig를 통한 정책 변경. 구성영역(config)만 변경하고, 사용영역에서는 변경이 필요하지 않다.
+ step 06 spring으로 전환. spring 컨테이너의 이해 (ApplicationContext -> 등록한 bean을 관리해준다.)

#### TODO
+ ~~OrderService에서 member 객체가 안넘어가는 이슈 해결해보기.~~
+ 이슈에 대한 정답 :  member를 저장하는 저장소에 static로 저장하지 않아 접근을 하지 못함.
+ Environment에 대한 설정값 읽어오기 및 셋팅 해보기. ( 다음 프로젝트에서 설정 해 볼 에정.)
+ BeanDefinition에 대한 공부하기.

### SPRING MEMO
+ spring container 
  > ApplicationContext라는 인터페이스 우리가 사용할 구현체는 AnnotationConfigApplicationContext 
  > 위의 구현체로 사용한 이유는 bean의 등록을 annotation을 기반으로 하였기 때문. 
  > + 주의사항 bean의 이름은 모두 다르게 설정하여야 한다. 
  > + bean을 등록 후 의존관계를 형성한다.
    
  > container에 등록된 bean을 조회하자. >> test code의 hello.core.beanfind라는 패키지 확인.
  > BeanFactory >> ApplicationContext >>  AnnotationConfigApplicationContext 순으로 되어있다. 
  
+ XML 문서를 활용한 설정 정보 .(test code의 hello.core.xml)
  
+ BeanDefinition에 대한 테스트 코드 (test code의 hello.core.definition)
  
+ SingleTon (test code의 hello.core.singleton)
  > + 웹 어플리케이션의 문제점 : 요청에 의해 new 연산자로 객체를 생성하면 모든 요청마다 객체가 생성됨.
  > + 요청에 의해 객체가 생성되고 소멸되는 메모리 소모가 심함. 
  > + 해결방안으로 singleton 으로 구현 (객체1개만 생성 후  공유.)
  > + spring container는 singleton의 모든 단점을 보완하여 사용할 수 있게 해준다. 
  > + singleton 객체를 생성하고 관리해주는 것 : 싱글톤 레지스트리
  > + 주의점 : 무상태로 유지해야 한다.  필드가 공유되면 안된다. 
  > + spring의 bean에 등록되어 있으면 등록되어 있는 것을 꺼내서 사용하게 해준다. 등록되어 있지 않다면, 새로 등록해준다..? 
  > + @Configuration 어노테이션을 사용하면, 해당 클래스의 인스턴스를 CGLIB 형태로 만든다ㅓ..? 어노테이션을 선언하지 않는다면, 싱글톤을 보장해주지 못한다. 

+ @ComponentScan
  > @Component 어노테이션이 들어있는 클래스를 찾아 bean 으로 자동 등록 해준다. 
  > bean의 이름은 해당 클래스의 클래스명이 bean 이름이 된다.(맨 앞글자만 소문자로 변경됨.) @Component 에 따로 이름을 지정할 수 있다. 

+ 중복 등록과 충돌
  > 자동등록 vs 자동등록 : @Component 어노테이션이 선언되어있는 이름이 같은 이름일 경우, ConflictingBeanDefinitionException 이 발생
  > 수동등록 vs 자동등록 : 수동 등록 bean 이 우선권을 가진다. main 클래스를 바로 실행한다면, 오류가 난다. 
  > 위의 문제점을 해결 하기 위해서는, overriding 설정을 application.properties 혹은 application.yml에 지정해준다.