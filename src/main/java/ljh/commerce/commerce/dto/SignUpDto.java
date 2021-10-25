package ljh.commerce.commerce.dto;

import ljh.commerce.commerce.domain.address.Address;
import ljh.commerce.commerce.domain.user.User;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpDto {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    private Address address;

    public User toEntity() {
        return User.builder()
                .userName(userName).password(password).email(email).address(address)
                .build();
    }

}
