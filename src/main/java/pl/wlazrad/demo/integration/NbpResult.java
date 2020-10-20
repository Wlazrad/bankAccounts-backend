package pl.wlazrad.demo.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NbpResult {
    private String Table;
    private String Currency;
    private String Code;
    BigDecimal Bid;
    BigDecimal Ask;
    private List<Rate> Rates;
}
