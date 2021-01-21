package br.com.acqio;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Debugger {
    private static boolean enable = false;

    public static void log(Object o) {
        if (enable) {
            System.out.println(o.toString());
        }
    }
}
