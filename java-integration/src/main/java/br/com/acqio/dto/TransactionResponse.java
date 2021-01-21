package br.com.acqio.dto;

import br.com.acqio.enums.CardApplication;
import br.com.acqio.enums.PaymentStatus;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TransactionResponse {
    private Long transactionId;
    private Integer status;
    private PaymentStatus paymentStatus;
    private String nsu;
    private String nsuOriginal;
    private String cardHiddenPan;
    private String authorizationCode;
    private String cardProductName;
    private String merchant;
    private String client;
    private String merchantHtml;
    private String clientHtml;
    private CardApplication cardApplication;
    private String cardHolderName;
}