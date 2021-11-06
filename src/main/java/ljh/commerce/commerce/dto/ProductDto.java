package ljh.commerce.commerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
    private Long id;
    private double price;
    private int categoryId;
    private String name;
    private String category;
    private String imageName;
}
