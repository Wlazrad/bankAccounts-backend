package pl.wlazrad.demo.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private int pesel;

    private BigDecimal money;

    private String password;

    public User(String name, String surname, int pesel, BigDecimal money, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.money = money;
        this.password = password;
    }
}

