package br.com.acqio;

import br.com.acqio.dto.StatusResponse;
import br.com.acqio.dto.TransactionRequest;
import br.com.acqio.dto.TransactionResponse;
import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.logging.Logger;

@NoArgsConstructor
public class Operator {

    private static final Logger LOGGER = Logger.getLogger(Operator.class.getName());
    private static final String BASE_URL = "http://localhost:12030/api/transaction";

    public StatusResponse start(TransactionRequest transactionRequest) {
        Gson gson = new Gson();
        String payload = gson.toJson(transactionRequest);

        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + "/start");
        builder.post(RequestBody.create(MediaType.parse("application/json"), payload));
        Request request = builder.build();

        try (okhttp3.Response response = HTTPConnect.getOkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Debugger.log(json);
                return gson.fromJson(json, StatusResponse.class);
            }
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

    public StatusResponse getStatus() {
        Gson gson = new Gson();

        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + "/status");
        builder.get();
        Request request = builder.build();

        try (okhttp3.Response response = HTTPConnect.getOkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Debugger.log(json);
                return gson.fromJson(json, StatusResponse.class);
            }
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

    public StatusResponse sendCharge(int installment) {
        Gson gson = new Gson();

        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + "/charge/" + installment);
        builder.get();
        Request request = builder.build();

        try (okhttp3.Response response = HTTPConnect.getOkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Debugger.log(json);
                return gson.fromJson(json, StatusResponse.class);
            }
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

    public StatusResponse revert(int id) {
        Gson gson = new Gson();

        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + "/revert/" + id);
        builder.get();
        Request request = builder.build();

        try (okhttp3.Response response = HTTPConnect.getOkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Debugger.log(json);
                return gson.fromJson(json, StatusResponse.class);
            }
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

    public TransactionResponse getReceipt() {
        Gson gson = new Gson();

        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + "/receipt/");
        builder.get();
        Request request = builder.build();

        try (okhttp3.Response response = HTTPConnect.getOkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Debugger.log(json);
                return gson.fromJson(json, TransactionResponse.class);
            }
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return null;
    }

}