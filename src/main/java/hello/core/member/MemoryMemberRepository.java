package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



/**
 *  memory DB를 이용한 구현체
 */
@Component
public class MemoryMemberRepository implements MemberRepository { //step 01


    /**
     * 동시성 이슈 때문에, ConcurrentHashMap을 사용한다고 함. In 실무)
     *
     *
     * static으로 선언하는 이유는 어디에서든 접근하기 위함. 재사용? 등등..
     * 하나의 객체에 여러 사람이 접근하기 때문에 동시성 이슈로 인한 HashMap을 지양하고 ConcurrentHashMap을 사용하여야한다..?
     * 또한 key값으로 선언되어있는 Long type도 동시성을 해결해줄 AtomicLong type을 고려하여야한다.
     */
    private static final Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
