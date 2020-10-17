package pl.wlazrad.demo.integration;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class ResponseEntityMapper {
    NbpResult mapToNbpResult(ResponseEntity<NbpResult> responseEntity){
        return new NbpResult.NbpResultBuilder()
                .Currency(responseEntity.getBody().getCurrency())
                .Bid(new BigDecimal(String.valueOf(responseEntity.getBody().getBid())))
                .Ask(new BigDecimal(String.valueOf(responseEntity.getBody().getBid())))
                .build();
    }
}

