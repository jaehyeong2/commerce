package ljh.commerce.commerce.domain.product;

import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.categoryproduct.CategoryProduct;
import ljh.commerce.commerce.domain.orderproduct.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String name;
    private int price;
    private String imageName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<CategoryProduct> categoryProductList = new ArrayList<>();

}
