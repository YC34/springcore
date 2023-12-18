package hello.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 *  memory DB를 이용한 구현체
 */
public class MemoryMemberRepository implements MemberRepository{ //step 01


    /**
     * 동시성 이슈 때문에, ConcurrentHashMap을 사용한다고 함. In 실무)
     */
    private Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}