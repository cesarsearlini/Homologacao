package br.com.acqio;

import br.com.acqio.dto.StatusResponse;
import br.com.acqio.dto.TransactionRequest;
import br.com.acqio.enums.CardApplication;
import br.com.acqio.enums.TenantPlanMode;
import br.com.acqio.enums.TransactionStatus;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        //Example - Charge
        charge();
        //Example - Revert
        revert(1);
    }

    public static void charge() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setCardApplication(CardApplication.CREDITO);
        transactionRequest.setTenantPlanMode(TenantPlanMode.DISABLED);
        BigDecimal bigDecimal = new BigDecimal("2.00");
        transactionRequest.setValue(bigDecimal);
        Operator operator = new Operator();
        StatusResponse statusResponse = operator.start(transactionRequest);
        loop(operator, statusResponse);
    }

    public static void revert(int transactionId) {
        Operator operator = new Operator();
        operator.revert(transactionId);
    }

    private static void loop(Operator operator, StatusResponse statusResponse) {
        boolean run = true;
        while (run) {
            switch (TransactionStatus.toEnum(statusResponse.getStatus())) {
                case PROCESSING:
                case PROCESSING_CHARGE:
                    statusResponse = operator.getStatus();
                    break;
                case WAITING_CHARGE:
                    statusResponse = operator.sendCharge(1);
                    break;
                case SUCCESS:
                    System.out.println(operator.getReceipt().toString());
                    run = false;
                    break;
                case NOT_FOUND:
                case INACTIVE:
                default:
                    run = false;
                    break;
            }
        }
    }

}