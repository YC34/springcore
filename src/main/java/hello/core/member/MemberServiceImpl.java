package hello.core.member;

import hello.core.member.Member;

public class MemberServiceImpl implements MemberService{ //step 01


    // 선택하고자 하는 구현체를 선택.
    private final MemberRepository memberRepository ;

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



}
