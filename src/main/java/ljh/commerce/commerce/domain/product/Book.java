package ljh.commerce.commerce.domain.product;


import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Book extends Product {

    private String author;
    private String isbn;
}
