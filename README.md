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



