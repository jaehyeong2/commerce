package ljh.commerce.commerce.domain.product;

import ljh.commerce.commerce.domain.category.Category;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private int price;
    private String imageName;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "image_id")
//    private ProductImage productImage;

}
