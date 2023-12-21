package hello.core.singleton;

public class SingletonService {

    // static 영역 (class영역..? )에 1개만 할당.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // private로 생성자를 만들어 new 로 새로운 객체를 생성하지 못하게 막는다.
    private SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 호출 성공 ");
    }
}
