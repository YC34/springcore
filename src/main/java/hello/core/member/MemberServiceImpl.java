package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService{ //step 01


    // 선택하고자 하는 구현체를 선택.
    private final MemberRepository memberRepository ;


    @Autowired // ac.getBean("memberRepository", MemberRepository.class); 와 비슷한 형태로 등록해준다.. ?
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
