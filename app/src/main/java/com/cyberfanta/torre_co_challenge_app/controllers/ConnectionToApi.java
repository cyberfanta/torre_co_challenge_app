package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectionToApi {
    /**
     * Objects to read data from server
     */
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public String getJson (String url, String request_type) throws ConnectionException {
        Request request;

        if (request_type.toLowerCase().equals("get")){
            request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
        } else if (request_type.toLowerCase().equals("post")) {
            RequestBody requestBody = new FormBody.Builder()
//                    .add("size", "20")
                    .build();
            request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
        } else {
            throw new ConnectionException("NOT VALID KIND");
        }

        String responseJSON;
        try {
            Response response = CLIENT.newCall(request).execute();

            responseJSON = Objects.requireNonNull(response.body()).string();
            Objects.requireNonNull(response.body()).close();

            if (responseJSON.contains("\"code\":\"020000\""))
                throw new ConnectionException("NAME_EMPTY");

            if (responseJSON.contains("\"code\":\"011002\""))
                throw new ConnectionException("OBJECT_NOT_FOUND");

            if (responseJSON.toLowerCase().contains("not found"))
                throw new ConnectionException("NOT FOUND");

        } catch (IOException e) {
            throw new ConnectionException("OBJECT_LOAD_FAIL");
        }
        return responseJSON;
    }
}
