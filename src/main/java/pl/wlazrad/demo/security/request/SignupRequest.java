package pl.wlazrad.demo.security.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SignupRequest {

    private String name;

    private String surname;

    private int pesel;

    private BigDecimal money;

    private String password;
}
