package br.com.acqio.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public enum TransactionStatus {
    NOT_FOUND(-2),
    INACTIVE(-1),
    SUCCESS(0),
    PROCESSING(1),
    WAITING_CHARGE(2),
    PROCESSING_CHARGE(3);

    private final Integer code;

    private static final Map<Integer, TransactionStatus> map = new HashMap<>();

    static {
        for (TransactionStatus s : values()) {
            map.put(s.getCode(), s);
        }
    }

    public static TransactionStatus toEnum(Integer code) {
        return map.get(code);
    }

}