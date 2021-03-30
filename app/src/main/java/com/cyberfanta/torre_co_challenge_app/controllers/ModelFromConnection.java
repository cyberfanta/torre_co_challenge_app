package com.cyberfanta.torre_co_challenge_app.controllers;

import android.util.Log;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.google.gson.Gson;


public class ModelFromConnection {
    private final String TAG = "ModelFromConnection";

    private final ConnectionToApi connectionToApi = new ConnectionToApi();
    private final Gson gson = new Gson();

    public <T> T getObject(Class<T> type, String url) throws ConnectionException {
        String string = connectionToApi.getJson(url);
        return gson.fromJson(string, type);
    }

    public <T> T postObject(Class<T> type, String url, int size, int offset) throws ConnectionException {
        Log.i(TAG, "pasó");
        String string = connectionToApi.postJson(url, size, offset);
        Log.i(TAG, string);
        return gson.fromJson(string, type);
    }
}
