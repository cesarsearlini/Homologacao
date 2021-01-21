package br.com.acqio.dto;

import br.com.acqio.enums.CardApplication;
import br.com.acqio.enums.TenantPlanMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TransactionRequest {
    private Integer installment = 1;
    private BigDecimal value;
    private CardApplication cardApplication;
    private TenantPlanMode tenantPlanMode = TenantPlanMode.DISABLED;
    private List<BinRange> binsAvailable = new ArrayList<>();
}