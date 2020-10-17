package pl.wlazrad.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wlazrad.demo.security.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByPesel(int pesel);
}
