package ljh.commerce.commerce.domain.item;

import ljh.commerce.commerce.domain.categoryitem.CategoryItem;
import ljh.commerce.commerce.domain.orderitem.OrderItem;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;



}
