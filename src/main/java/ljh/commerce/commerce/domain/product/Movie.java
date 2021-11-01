package ljh.commerce.commerce.domain.product;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Movie extends Product {
    private String director;
    private String actor;
}
