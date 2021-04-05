package com.cyberfanta.torre_co_challenge_app.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class BitmapFromConnection {
    private static final Map<String, Bitmap> bitmapMap = new LinkedHashMap<>(0);
    private int bitmapMapIterator = 0;

    public static synchronized void loadBitmap(String name, String url_bitmap) throws IOException {
        URL url = new URL(url_bitmap);

        if (bitmapMap.containsKey(name))
            return;

        Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        if (bitmap != null)
            bitmapMap.put(name, bitmap);
    }

    public static Bitmap getBitmap (String name) {
        return bitmapMap.get(name);
    }

    public static void getBitmap (String name, String url_bitmap) throws IOException {
        loadBitmap(name, url_bitmap);
        getBitmap(name);
    }

    public Bitmap nextBitmap() throws ConnectionException {
        if (bitmapMapIterator < bitmapMap.size())
            return (Bitmap) bitmapMap.values().toArray()[bitmapMapIterator++];

        throw new ConnectionException("NEED_LOAD_MORE_BITMAPS");
    }
}
