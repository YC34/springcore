package hello.core.member;


import org.springframework.stereotype.Component;

/**
 *  회원의 저장소.
 *  저장소의 다형성을 위한 인터페이스
 */

public interface MemberRepository { //step 01

    void save(Member member);

     Member findById(Long memberId);
}
