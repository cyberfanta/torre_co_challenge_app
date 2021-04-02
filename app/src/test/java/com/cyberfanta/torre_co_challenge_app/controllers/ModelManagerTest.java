package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;

import junit.framework.TestCase;

import org.junit.Assert;

public class ModelManagerTest extends TestCase {
    ModelManager modelManager;

    public void setUp() throws Exception {
        super.setUp();

        modelManager = new ModelManager();
    }

    public void testGetJob() {
        try {
            Assert.assertSame(modelManager.getJob("jw0qXRdx").getClass(), Job.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testNextJob() {
        try {
            Assert.assertSame(modelManager.nextJob().getClass(), Job.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testLoadJob() {
        try {
            modelManager.loadJob("jw0qXRdx");
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetBio() {
        try {
            Assert.assertSame(modelManager.getBio("julioleon2004").getClass(), Bio.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testNextBio() {
        try {
            Assert.assertSame(modelManager.nextBio().getClass(), Bio.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testLoadBio() {
        try {
            modelManager.loadBio("julioleon2004");
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetOpportunity() {
        try {
            modelManager.loadOpportunities(20, 0);
            com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem resultsItem = modelManager.nextOpportunity();
            Assert.assertSame(modelManager.getOpportunity(resultsItem.getId()).getClass(), com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testNextOpportunity() {
        try {
            modelManager.loadOpportunities(20, 0);
            Assert.assertSame(modelManager.nextOpportunity().getClass(), com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testLoadOpportunities() {
        try {
            modelManager.loadOpportunities(20, 0);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetPeople() {
        try {
            modelManager.loadPeoples(20, 0);
            com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem resultsItem = modelManager.nextPeople();
            Assert.assertSame(modelManager.getPeople(resultsItem.getUsername()).getClass(), com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testNextPeople() {
        try {
            modelManager.loadPeoples(20, 0);
            Assert.assertSame(modelManager.nextPeople().getClass(), com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testLoadPeoples() {
        try {
            modelManager.loadPeoples(20, 0);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }
}