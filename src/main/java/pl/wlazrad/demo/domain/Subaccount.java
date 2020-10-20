package pl.wlazrad.demo.domain;

import lombok.Data;
import pl.wlazrad.demo.security.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Subaccount extends Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Currency currency;

    BigDecimal amount;

    @ManyToOne
    private User user;
}
