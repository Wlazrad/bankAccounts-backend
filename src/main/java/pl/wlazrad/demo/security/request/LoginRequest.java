package pl.wlazrad.demo.security.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String pesel;

    private String password;
}
