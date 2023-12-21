package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixdiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // step 02


    private final MemberRepository memberRepository; // step 03
    private final DiscountPolicy discountPolicy; // 해결 책. step 03

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { //step 03
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }


    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
