package hello.core.order;


/**
 * 주문 정보 service interface
 */
public interface OrderService { // step 02

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
