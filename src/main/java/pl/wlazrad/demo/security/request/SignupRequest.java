package pl.wlazrad.demo.security.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String username;

    private int pesel;

    private String password;
}
