package ljh.commerce.commerce.dto;

import ljh.commerce.commerce.domain.address.Address;
import ljh.commerce.commerce.domain.user.User;
import lombok.Data;
import lombok.Getter;

@Data
public class SignUpDto {

    private String userName;
    private String password;
    private String email;

    private Address address;

    public User toEntity() {
        return User.builder()
                .userName(userName).password(password).email(email).address(address)
                .build();
    }

}
