package ljh.commerce.commerce.domain.categoryproduct;

import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryProduct {
    @Id
    @GeneratedValue
    @Column(name = "category_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
