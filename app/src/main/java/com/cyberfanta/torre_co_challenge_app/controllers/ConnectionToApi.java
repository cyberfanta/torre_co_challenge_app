package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectionToApi {
//    private final String TAG = "ConnectionToApi";

    // Objects to read data from server
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public String getJson (String url) throws ConnectionException {
        return loadJson(new Request.Builder().url(url).get().build());
    }

    @SuppressWarnings("deprecation")
    public String postJson (String url, int size, int offset) throws ConnectionException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, "");

        return loadJson(new Request.Builder()
                .url(url.concat("?size=").concat(String.valueOf(size)).concat("&offset=").concat(String.valueOf(offset)))
                .post(requestBody)
                .build());
    }

    private String loadJson (Request request) throws ConnectionException {
        String answer;
        try {
            Response response = CLIENT.newCall(request).execute();

            answer = Objects.requireNonNull(response.body()).string();
            Objects.requireNonNull(response.body()).close();

            if (answer.contains("\"code\":\"020000\""))
                throw new ConnectionException("NAME_EMPTY");

            if (answer.contains("\"code\":\"011002\""))
                throw new ConnectionException("OBJECT_NOT_FOUND");

            if (answer.toLowerCase().contains("not found"))
                throw new ConnectionException("NOT FOUND");

            if (answer.toLowerCase().contains("\"status\":415"))
                throw new ConnectionException("UNSUPPORTED MEDIA TYPE");

            if (answer.toLowerCase().contains("\"status\":400"))
                throw new ConnectionException("INTERNAL SERVER ERROR");

        } catch (IOException e) {
            throw new ConnectionException("CONNECTION_FAIL");
        }
        return answer;
    }
}
