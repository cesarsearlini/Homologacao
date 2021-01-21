package br.com.acqio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StatusResponse {
    private Long id;
    private Integer status;
    private List<String> actions;
    private String message;
    private List<InstallmentInfo> installmentInfo;
    private CardInfo cardInfo;
}