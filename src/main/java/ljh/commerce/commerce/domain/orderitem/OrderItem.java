package ljh.commerce.commerce.domain.orderitem;

import ljh.commerce.commerce.domain.item.Item;
import ljh.commerce.commerce.domain.order.Order;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int OrderPrice; //주문 개수
    private int count; // 주문수량

    public void setOrder(Order order) {
        this.order = order;
    }
}
