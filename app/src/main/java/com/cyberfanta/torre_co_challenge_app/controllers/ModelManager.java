package com.cyberfanta.torre_co_challenge_app.controllers;

import android.util.Log;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;
import com.cyberfanta.torre_co_challenge_app.models.peoples.Peoples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModelManager {
    @SuppressWarnings("FieldCanBeLocal")
    private final String TAG;

    private final String[] url = new String[]{
            "https://torre.co/api/opportunities/",  //https://torre.co/api/opportunities/$id
            "https://torre.bio/api/bios/",  //https://torre.bio/api/bios/$username
            "https://search.torre.co/opportunities/_search/", //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
            "https://search.torre.co/people/_search/"  //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
    };
    private final ModelFromConnection modelFromConnection = new ModelFromConnection();

    private final Map<String, Job> jobMap = new LinkedHashMap<>(0);
    private Iterator<Map.Entry<String, Job>> jobMapIterator;

    private final Map<String, Bio> bioMap = new LinkedHashMap<>(0);
    private Iterator<Map.Entry<String, Bio>> bioMapIterator;

    private final Map<String, com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> opportunitiesMap = new LinkedHashMap<>(0);
    private Iterator<Map.Entry<String, com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem>> opportunitiesMapIterator;

    private final Map<String, com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> peoplesMap = new LinkedHashMap<>(0);
    private Iterator<Map.Entry<String, com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem>> peoplesMapIterator;

    public ModelManager(){
        TAG = "ModelManager";

        jobMapIterator = jobMap.entrySet().iterator();
        bioMapIterator = bioMap.entrySet().iterator();
        opportunitiesMapIterator = opportunitiesMap.entrySet().iterator();
        peoplesMapIterator = peoplesMap.entrySet().iterator();
    }

    //Getters
    //-- Job
    public Job getJob(String name) throws ConnectionException {
        if (jobMap.containsKey(name))
            return jobMap.get(name);

        loadJob(name);
        return jobMap.get(name);
    }

    public Job nextJob() throws ConnectionException {
        if (jobMapIterator.hasNext())
            return jobMapIterator.next().getValue();

        if (jobMap.size() < 1)
            loadJob("jw0qXRdx");

        jobMapIterator = jobMap.entrySet().iterator();
        return jobMapIterator.next().getValue();
    }

    public void loadJob(String name) throws ConnectionException {
        if (jobMap.containsKey(name))
            return;

        Job job = modelFromConnection.getObject(Job.class, url[0].concat(name));
        jobMap.put(job.getId(), job);
    }

    //-- Bio
    public Bio getBio(String name) throws ConnectionException {
        if (bioMap.containsKey(name))
            return bioMap.get(name);

        loadBio(name);
        return bioMap.get(name);
    }

    public Bio nextBio() throws ConnectionException {
        if (bioMapIterator.hasNext())
            return bioMapIterator.next().getValue();

        if (bioMap.size() < 1)
            loadBio("julioleon2004");

        bioMapIterator = bioMap.entrySet().iterator();
        return bioMapIterator.next().getValue();
    }

    public void loadBio(String name) throws ConnectionException{
        if (bioMap.containsKey(name))
            return;

        Bio bio = modelFromConnection.getObject(Bio.class, url[1].concat(name));
        bioMap.put(bio.getPerson().getPublicId(), bio);
    }

    //-- Opportunities
    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem getOpportunity(String id){
        if (opportunitiesMap.containsKey(id))
            return opportunitiesMap.get(id);
        return null;
    }

    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem nextOpportunity() throws ConnectionException {
        if (opportunitiesMap.size() < 1) {
            loadOpportunities(20, 0);
            opportunitiesMapIterator = opportunitiesMap.entrySet().iterator();
        }

        return opportunitiesMapIterator.next().getValue();
    }

    public void loadOpportunities(int size, int offset) throws ConnectionException {
        Opportunities opportunities = modelFromConnection.postObject(Opportunities.class, url[2], size, offset);
        List <com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> resultsItems = opportunities.getResults();

        for (com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem resultsItem: resultsItems)
            opportunitiesMap.put(resultsItem.getId(), resultsItem);
    }

    //-- Peoples
    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem getPeople(String userName) {
        if (peoplesMap.containsKey(userName))
            return peoplesMap.get(userName);
        return null;
    }

    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem nextPeople() throws ConnectionException {
        if (peoplesMap.size() < 1) {
            loadPeoples(20, 0);
            peoplesMapIterator = peoplesMap.entrySet().iterator();
        }

        return peoplesMapIterator.next().getValue();
    }

    public void loadPeoples(int size, int offset) throws ConnectionException {
        Peoples peoples = modelFromConnection.postObject(Peoples.class, url[3], size, offset);
        List <com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> resultsItems = peoples.getResults();

        for (com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem resultsItem: resultsItems)
            peoplesMap.put(resultsItem.getUsername(), resultsItem);
    }

    //---
}
