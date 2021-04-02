package com.cyberfanta.torre_co_challenge_app.controllers;

import android.graphics.Bitmap;

import junit.framework.TestCase;

import org.junit.Assert;

import java.io.IOException;

public class BitmapFromConnectionTest extends TestCase {
    BitmapFromConnection bitmapFromConnection;

    public void setUp() throws Exception {
        super.setUp();
        bitmapFromConnection = new BitmapFromConnection();
    }

//    public void testGetBitmap() {
//        try {
//            Bitmap bitmap = bitmapFromConnection.getBitmap("name", "https://starrgate.s3.amazonaws.com:443/users/2d9b56696587182b0d536620c6b5a24bd9ef268e/profile_uRlv914.jpg");
//            Assert.assertNotNull(bitmap);
//        } catch (IOException e) {
//            Assert.fail();
//        }
//    }
//
//    public void testGetBitmap2() {
//        try {
//            Bitmap bitmap = bitmapFromConnection.getBitmap2("name", "https://starrgate.s3.amazonaws.com:443/users/2d9b56696587182b0d536620c6b5a24bd9ef268e/profile_uRlv914.jpg");
//            Assert.assertNotNull(bitmap);
//        } catch (IOException e) {
//            Assert.fail();
//        }
//    }
}