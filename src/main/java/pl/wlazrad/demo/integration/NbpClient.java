package pl.wlazrad.demo.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class NbpClient {

    private final RestTemplate restTemplate;
    //http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    @PostConstruct
    public String getUsdAsk(){
        ResponseEntity<NbpResult> forEntity = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/", NbpResult.class, entity);
        System.out.println(forEntity.getBody().getRates().get(0).getAsk());
        return forEntity.getBody().getRates().get(0).getAsk();
    }

    @PostConstruct
    public String getUsdBid(){
        ResponseEntity<NbpResult> forEntity = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/", NbpResult.class, entity);
        System.out.println(forEntity.getBody().getRates().get(0).getBid());
        return forEntity.getBody().getRates().get(0).getBid();
    }

}
