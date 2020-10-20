package pl.wlazrad.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wlazrad.demo.domain.Currency;
import pl.wlazrad.demo.integration.NbpClient;
import pl.wlazrad.demo.repositories.SubaccountRepository;
import pl.wlazrad.demo.security.User;
import pl.wlazrad.demo.security.repository.UserRepository;
import pl.wlazrad.demo.services.SubaccountService;

import java.math.BigDecimal;
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

    @Autowired
    SubaccountService subaccountService;

    @PostMapping(value = "/sendmoney/{amount}/{currency}")
    public void sendMoney(@PathVariable BigDecimal amount, @PathVariable Currency currency) {
        subaccountService.sendMoney(amount, currency);
    }

    @GetMapping(value = "/showAll")
    public User showAll() {
        Optional<User> currentUser = userRepository.findByPesel(getCurrentUserPesel());
        return currentUser.orElse(null);
    }
}
