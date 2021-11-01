package ljh.commerce.commerce.domain.orderproduct;

import ljh.commerce.commerce.domain.product.Product;
import ljh.commerce.commerce.domain.order.Order;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderProduct {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Product item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int OrderPrice; //주문 개수
    private int count; // 주문수량

    public void setOrder(Order order) {
        this.order = order;
    }
}
