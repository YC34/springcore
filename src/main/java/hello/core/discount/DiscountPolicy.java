package hello.core.discount;

import hello.core.member.Member;

/**
 * 할인 정책의 interface
 */


public interface DiscountPolicy { // step 02


    /**
     * @return 할인 금액
     *
     */
    int discount(Member member,int price);

}
