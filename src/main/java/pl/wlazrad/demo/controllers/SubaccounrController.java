package pl.wlazrad.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wlazrad.demo.domain.Currency;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.integration.NbpClient;
import pl.wlazrad.demo.repositories.SubaccountRepository;
import pl.wlazrad.demo.security.User;
import pl.wlazrad.demo.security.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static pl.wlazrad.demo.security.SecurityUtils.getCurrentUserPesel;

@RestController
@RequestMapping("/api")
public class SubaccounrController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    NbpClient nbpClient;

    @Autowired
    SubaccountRepository subaccountRepository;

    @PostMapping(value = "/sendmoney/{amount}/{currency}")
    public void sendMoney(@PathVariable BigDecimal amount, @PathVariable Currency currency) {
        Optional<User> currentUser = userRepository.findByPesel(getCurrentUserPesel());
        Subaccount subaccountPln = null;
        Subaccount subaccountUsd = null;
        List<Subaccount> subaccountList = subaccountRepository.findAllByUser(currentUser.get());


        if (subaccountList.get(0).getCurrency() == Currency.PLN) {
            subaccountPln = subaccountList.get(0);
        } else {
            subaccountUsd = subaccountList.get(0);
        }

        if (subaccountList.get(1).getCurrency() == Currency.USD) {
            subaccountUsd = subaccountList.get(1);
        } else {
            subaccountPln = subaccountList.get(1);
        }

        if(currency==Currency.PLN) {
            subaccountPln.setAmount(subaccountPln.getAmount().subtract(amount));
            subaccountUsd.setAmount(amount.subtract(new BigDecimal(nbpClient.getUsdAsk())));
        }else {
            subaccountUsd.setAmount(subaccountUsd.getAmount().subtract(amount));
            subaccountPln.setAmount(amount.multiply(new BigDecimal(nbpClient.getUsdBid())));
        }
    }

    @GetMapping(value = "/showAll")
    public List<Subaccount> showAll(){
        Optional<User> currentUser = userRepository.findByPesel(getCurrentUserPesel());
        return subaccountRepository.findAllByUser(currentUser.get());
    }
}
