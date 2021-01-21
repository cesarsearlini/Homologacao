package br.com.acqio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardInfo {
    private boolean requireSignature;
    private String holderName;
    private String bin;
}