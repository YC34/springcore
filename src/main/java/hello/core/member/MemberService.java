package hello.core.member;


/**
 * 서비스 로직 인터페이스
 */
public interface MemberService { // step 01

    void join(Member member);

    Member findMember(Long memberId);

}
