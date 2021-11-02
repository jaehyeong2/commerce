package ljh.commerce.commerce.domain.product;

import ljh.commerce.commerce.domain.categoryproduct.CategoryProduct;
import ljh.commerce.commerce.domain.orderproduct.OrderProduct;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderItemList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<CategoryProduct> categoryProductList = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;

}
