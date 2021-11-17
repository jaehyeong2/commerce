package ljh.commerce.commerce.dto;

import ljh.commerce.commerce.domain.image.ProductImage;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResDto {
    private Long id;
    private int price;
    private long categoryId;
    private String name;
    private String category;
    private String imageName;
//    private ProductImage productImage;
    private String description;
}
