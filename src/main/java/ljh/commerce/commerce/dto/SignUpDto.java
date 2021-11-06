package ljh.commerce.commerce.dto;

import ljh.commerce.commerce.domain.user.User;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpDto {

    @Size(min = 2,max = 20)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    public User toEntity() {
        return User.builder()
                .username(username).password(password).email(email)
                .build();
    }
}
