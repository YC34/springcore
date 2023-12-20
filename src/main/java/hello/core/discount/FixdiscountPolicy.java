package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;


/**
 *
 * 정액 할인에 대한 구현체 . (DiscountPolicy)에 대한 구현체.
 *
 */
public class FixdiscountPolicy implements DiscountPolicy {   //step 02

    private int discountFixAmount =1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum type은 ==을 사용한다.
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
