package ljh.commerce.commerce.domain.product;

import ljh.commerce.commerce.domain.categoryitem.CategoryItem;
import ljh.commerce.commerce.domain.orderproduct.OrderProduct;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter
public abstract class Product {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<OrderProduct> orderItemList = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;



}
