package pl.wlazrad.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.security.SecurityUtils;

@RestController
@RequestMapping("/api")
public class AccountController {


    @PostMapping(value = "/account")
    public boolean createAccount(Subaccount subaccount) {

        SecurityUtils.getCurrentUserPesel();

        return false;
    }
}
