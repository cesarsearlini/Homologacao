package br.com.acqio.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public enum TenantPlanMode {

    DISABLED("Desativar"),
    TENANT("Lojista e Portador"),
    MDR_0("MDR-0 CRÉDITO/DEBITO");

    private final String description;

}