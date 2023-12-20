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
+ 

#### TODO
+ ~~OrderService에서 member 객체가 안넘어가는 이슈 해결해보기.~~
+ 이슈에 대한 정답 :  member를 저장하는 저장소에 static로 저장하지 않아 접근을 하지 못함.


