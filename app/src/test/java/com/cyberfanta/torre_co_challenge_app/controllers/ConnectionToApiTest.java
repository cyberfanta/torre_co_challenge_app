package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;

import junit.framework.TestCase;

import org.junit.Assert;

public class ConnectionToApiTest extends TestCase {
    private final String TAG = "ConnectionToApiTest";
    private ConnectionToApi connectionToApi;
    private String[] url;

    public void setUp() throws Exception {
        super.setUp();

        connectionToApi = new ConnectionToApi();
        url = new String[]
                {
                        "https://torre.bio/api/bios/",                     //https://torre.bio/api/bios/$username
                        "https://torre.co/api/opportunities/",             //https://torre.co/api/opportunities/$id
                        "https://search.torre.co/people/_search/",         //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
                        "https://search.torre.co/opportunities/_search/"   //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
                };
    }

    public void testGetJson_bio_ok() {
        try {
            Assert.assertNotNull(connectionToApi.getJson(url[0].concat("julioleon2004")));
//            answer = connectionToApi.getJson(url[0].concat("julioleon2004"), "get");
//            Log.i(TAG, answer);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetJson_bio_not_ok() {
        try {
            Assert.assertNull(connectionToApi.getJson(url[0].concat("bot123")));
        } catch (ConnectionException e) {
            Assert.assertTrue(true);
        }
    }

    public void testGetJson_job_ok() {
        try {
            Assert.assertNotNull(connectionToApi.postJson(url[1].concat("jw0qXRdx"), 1));
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetJson_job_not_ok() {
        try {
            Assert.assertNull(connectionToApi.postJson(url[1].concat("jw0qXRdx1"), 1));
        } catch (ConnectionException e) {
            Assert.assertTrue(true);
        }
    }

    public void testGetJson_peoples_ok() {
        try {
            Assert.assertNotNull(connectionToApi.postJson(url[2], 1));
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetJson_opportunities_ok() {
        try {
            Assert.assertNotNull(connectionToApi.postJson(url[3], 1));
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }
}