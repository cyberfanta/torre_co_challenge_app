package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.google.gson.Gson;


public class ModelFromConnection {
    private final ConnectionToApi connectionToApi = new ConnectionToApi();
    private final Gson gson = new Gson();

    public <T> T getObject(Class<T> type, String url) throws ConnectionException {
        String string = connectionToApi.getJson(url);
        return gson.fromJson(string, type);
    }

    public <T> T postObject(Class<T> type, String url, int size, int offset) throws ConnectionException {
        String string = connectionToApi.postJson(url, size, offset);
        return gson.fromJson(string, type);
    }
}
