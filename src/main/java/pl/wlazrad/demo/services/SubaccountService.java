package pl.wlazrad.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wlazrad.demo.domain.Currency;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.integration.NbpClient;
import pl.wlazrad.demo.repositories.SubaccountRepository;
import pl.wlazrad.demo.security.User;
import pl.wlazrad.demo.security.repository.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import static pl.wlazrad.demo.security.SecurityUtils.getCurrentUserPesel;

@Service
public class SubaccountService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NbpClient nbpClient;

    @Autowired
    SubaccountRepository subaccountRepository;

    public void sendMoney(BigDecimal amount,Currency currency) {
        Optional<User> currentUser = userRepository.findByPesel(getCurrentUserPesel());

        assert currentUser.orElse(null) != null;
        List<Subaccount> subaccountList = currentUser.orElse(null).getSubaccountList();

        Subaccount subaccountPln;
        Subaccount subaccountUsd;

        if (subaccountList.get(0).getCurrency() == Currency.PLN) {
            subaccountPln = subaccountList.get(0);
            subaccountUsd = subaccountList.get(1);
        } else {
            subaccountUsd = subaccountList.get(0);
            subaccountPln = subaccountList.get(1);
        }
        if (currency == Currency.PLN) {
            subaccountPln.setAmount(subaccountPln.getAmount().add(amount));
            subaccountUsd.setAmount(subaccountUsd.getAmount().subtract(amount.divide(new BigDecimal(nbpClient.getUsdBid()),2,RoundingMode.CEILING)));
            subaccountRepository.save(subaccountPln);
            subaccountRepository.save(subaccountUsd);
        } else {
            subaccountPln.setAmount(subaccountPln.getAmount().subtract(amount.multiply(new BigDecimal(nbpClient.getUsdAsk()))));
            subaccountUsd.setAmount(subaccountUsd.getAmount().add(amount));
            subaccountRepository.save(subaccountPln);
            subaccountRepository.save(subaccountUsd);
        }
    }
}
