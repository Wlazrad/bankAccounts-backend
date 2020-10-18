package pl.wlazrad.demo.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import pl.wlazrad.demo.security.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Account extends User{

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_subaccount")
    private List<Subaccount> subaccountList;

    @CreatedDate
    @Column(name = "created_date")
    private final ZonedDateTime createdDate = ZonedDateTime.now();
}
