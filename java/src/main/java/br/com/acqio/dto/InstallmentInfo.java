package br.com.acqio.dto;

import br.com.acqio.enums.CardApplication;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class InstallmentInfo {
    private String cardBrand;
    private CardApplication cardApplication;
    private Integer installment;
    private BigDecimal installmentValue;
    private BigDecimal total;
}