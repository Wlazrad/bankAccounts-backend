package pl.wlazrad.demo.security.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;

    @ValidDateOfBirth
    @NotNull
    private String pesel;

    @NotNull
    private BigDecimal money;
    @NotBlank
    private String password;
}
