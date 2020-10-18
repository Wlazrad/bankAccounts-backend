package pl.wlazrad.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {
    @PostMapping(value = "/account")
    public boolean createAccount() {
        return false;
    }
}
