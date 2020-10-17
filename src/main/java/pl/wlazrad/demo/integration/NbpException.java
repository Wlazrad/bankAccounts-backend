package pl.wlazrad.demo.integration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class  NbpException extends RuntimeException{
    private HttpStatus httpStatus;
    private String code;
}

