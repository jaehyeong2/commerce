package ljh.commerce.commerce.domain.category;

import ljh.commerce.commerce.domain.categoryproduct.CategoryProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<CategoryProduct> categoryProductList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public void setParent(Category parent) {
        this.parent = parent;
    }

    //연관관계 편의 메소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
}
