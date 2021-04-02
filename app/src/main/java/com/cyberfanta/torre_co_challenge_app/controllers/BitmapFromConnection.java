package com.cyberfanta.torre_co_challenge_app.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class BitmapFromConnection {
    private final Map<String, Bitmap> bitmapMap = new LinkedHashMap<>(0);
    private int bitmapMapIterator = 0;

    public synchronized void loadBitmap(String name, String url_bitmap) throws IOException {
        URL url = new URL(url_bitmap);

        if (bitmapMap.containsKey(name))
            return;

        Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        if (bitmap != null)
            bitmapMap.put(name, bitmap);
    }

    public Bitmap getBitmap (String name) {
        return bitmapMap.get(name);
    }

    public Bitmap nextBitmap() throws ConnectionException {
        if (bitmapMapIterator < bitmapMap.size())
            return (Bitmap) bitmapMap.values().toArray()[bitmapMapIterator++];

        throw new ConnectionException("NEED_LOAD_MORE_BITMAPS");
    }


//    public Bitmap getBitmap(String name, String url_bitmap) throws IOException {
//        URL url = new URL(url_bitmap);
//
//        if (bitmapMap.containsKey(name))
//            return bitmapMap.get(name);
//
//        Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        if (bitmap != null)
//            bitmapMap.put(url.getPath(), bitmap);
//        return bitmap;
//    }
//
//    public Bitmap getBitmap2(String name, String url_bitmap) throws IOException {
//        URL url = new URL(url_bitmap);
//
//        if (bitmapMap.containsKey(name))
//            return bitmapMap.get(name);
//
//        InputStream in = url.openConnection().getInputStream();
//        BufferedInputStream bis = new BufferedInputStream(in,1024*8);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        int len=0;
//        byte[] buffer = new byte[1024];
//        while((len = bis.read(buffer)) != -1){
//            out.write(buffer, 0, len);
//        }
//        out.close();
//        bis.close();
//
//        byte[] data = out.toByteArray();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
//        if (bitmap != null)
//            bitmapMap.put(url.getPath(), bitmap);
//        return bitmap;
//    }
}
