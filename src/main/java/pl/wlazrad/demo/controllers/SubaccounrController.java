package pl.wlazrad.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wlazrad.demo.domain.Subaccount;
import pl.wlazrad.demo.security.SecurityUtils;
import pl.wlazrad.demo.services.SubaccountService;

@RestController
@RequestMapping("/api")
public class SubaccounrController {

    @Autowired
    SubaccountService subaccountService;

    @PostMapping(value = "/subaccount")
    public Subaccount createSubaccount(@RequestBody Subaccount subaccount) {
        System.out.println("lala" + SecurityUtils.getCurrentUserPesel());
        subaccountService.saveSubaccount(subaccount);
        return subaccount;
    }
}
