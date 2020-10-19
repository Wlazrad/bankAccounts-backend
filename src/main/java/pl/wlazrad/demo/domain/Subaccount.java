package pl.wlazrad.demo.domain;

import lombok.Data;
import pl.wlazrad.demo.security.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Data
@Entity
public class Subaccount extends Account{
    @Id
    private Long id;
    Currency currency;
    BigDecimal amount;
    @ManyToOne
    private User user;

}
