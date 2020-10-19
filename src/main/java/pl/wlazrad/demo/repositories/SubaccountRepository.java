package pl.wlazrad.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.security.User;

import java.util.List;

@Repository
public interface SubaccountRepository extends JpaRepository<Subaccount, Long> {

    List<Subaccount> findAllByUser(User user);
}
