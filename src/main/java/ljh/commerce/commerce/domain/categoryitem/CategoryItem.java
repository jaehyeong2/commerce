package ljh.commerce.commerce.domain.categoryitem;

import ljh.commerce.commerce.domain.category.Category;
import ljh.commerce.commerce.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryItem {
    @Id
    @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
