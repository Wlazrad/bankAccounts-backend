package pl.wlazrad.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.wlazrad.demo.*" })
public class BankAccountsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountsBackendApplication.class, args);
    }

}
