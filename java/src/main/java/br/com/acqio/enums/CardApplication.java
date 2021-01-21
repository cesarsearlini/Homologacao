package br.com.acqio.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public enum CardApplication {
    CREDITO("01", "Crédito"),
    DEBITO("02", "Débito");

    private final String code;
    private final String application;

}