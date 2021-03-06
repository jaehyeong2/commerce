package ljh.commerce.commerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
    private Long id;
    private int price;
    private long categoryId;
    private String name;
    private String category;
    private String imageName;
    private String description;
}
