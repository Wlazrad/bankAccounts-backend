package pl.wlazrad.demo.security.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private Long id;
    private String name;
}
