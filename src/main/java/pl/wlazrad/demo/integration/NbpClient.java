package pl.wlazrad.demo.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class NbpClient {

    private final RestTemplate restTemplate;
    public static final String NBP_USD = "http://api.nbp.pl/api/exchangerates/rates/c/usd/" + LocalDate.now();

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    @PostConstruct
    public String getUsdAsk(){
        ResponseEntity<NbpResult> forEntity = restTemplate.getForEntity(NBP_USD, NbpResult.class, entity);
        return Objects.requireNonNull(forEntity.getBody()).getRates().get(0).getAsk();
    }

    @PostConstruct
    public String getUsdBid(){
        ResponseEntity<NbpResult> forEntity = restTemplate.getForEntity(NBP_USD, NbpResult.class, entity);
        return Objects.requireNonNull(forEntity.getBody()).getRates().get(0).getBid();
    }
}
