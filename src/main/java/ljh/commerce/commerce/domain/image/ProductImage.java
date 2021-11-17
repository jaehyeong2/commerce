package ljh.commerce.commerce.domain.image;


import ljh.commerce.commerce.domain.product.Product;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class ProductImage {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String imageUrl;

    @OneToOne(mappedBy = "productImage")
    private Product product;
}
