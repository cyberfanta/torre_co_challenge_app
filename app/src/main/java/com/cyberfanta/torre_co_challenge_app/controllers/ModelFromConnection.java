package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.google.gson.Gson;


public class ModelFromConnection {
    private final String TAG = "ModelFromConnection";

    private final ConnectionToApi connectionToApi = new ConnectionToApi();
    private final Gson gson = new Gson();

    public <T> T getObject(Class<T> type, String url, String request_type) throws ConnectionException {
        String string = connectionToApi.getJson(url, request_type);
        return gson.fromJson(string, type);
    }
}
