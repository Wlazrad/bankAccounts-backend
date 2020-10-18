package pl.wlazrad.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wlazrad.demo.domain.Subaccount;

@Repository
public interface SubaccountRepository extends JpaRepository<Subaccount, Long> { }
