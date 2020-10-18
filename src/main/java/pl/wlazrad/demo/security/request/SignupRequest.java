package pl.wlazrad.demo.security.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import java.math.BigDecimal;

@Getter
@Setter
public class SignupRequest {

    private String name;

    private String surname;

    @PESEL
    private int pesel;

    private BigDecimal money;

    private String password;
}
