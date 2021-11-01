package ljh.commerce.commerce.domain.product;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Album extends Product {
    private String artist;
    private String etc;
}
