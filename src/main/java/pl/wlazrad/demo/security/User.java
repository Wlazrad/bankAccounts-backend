package pl.wlazrad.demo.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wlazrad.demo.domain.Subaccount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String pesel;

    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Subaccount> subaccountList = new ArrayList<>();

    public User(String name, String surname, String pesel, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.password = password;
    }

    public User(String name, String surname, String pesel, String password, List<Subaccount> subaccountList) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.password = password;
        this.subaccountList = subaccountList;
    }
}

