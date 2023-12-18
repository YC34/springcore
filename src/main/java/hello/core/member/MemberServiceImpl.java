package hello.core.member;

public class MemberServiceImpl implements MemberService{ //step 01


    // 선택하고자 하는 구현체를 선택.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
