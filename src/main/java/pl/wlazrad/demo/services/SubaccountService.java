package pl.wlazrad.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.repositories.SubaccountRepository;
import pl.wlazrad.demo.security.SecurityUtils;
import pl.wlazrad.demo.security.repository.UserRepository;


@Service
public class SubaccountService {

    @Autowired
    SubaccountRepository subaccountRepository;

    @Autowired
    UserRepository userRepository;

    public Subaccount saveSubaccount(Subaccount subaccount) {
        subaccount.setUser(userRepository.findByPesel(SecurityUtils.getCurrentUserPesel()).get());
        return subaccountRepository.save(subaccount);
    }

}
