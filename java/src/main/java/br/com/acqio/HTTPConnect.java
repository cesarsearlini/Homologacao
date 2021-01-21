package br.com.acqio;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HTTPConnect {

    private static OkHttpClient okHttpClient;
    public static final int CONNECTION_TIMEOUT = 10;
    public static final int READ_TIMEOUT = 10;
    public static final int WRITE_TIMEOUT = 30;

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = builder();
        }
        return okHttpClient;
    }

    public static OkHttpClient builder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);

        return builder.build();
    }

}