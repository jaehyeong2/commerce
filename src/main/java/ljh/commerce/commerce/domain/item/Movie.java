package ljh.commerce.commerce.domain.item;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Movie extends Item {
    private String director;
    private String actor;
}
