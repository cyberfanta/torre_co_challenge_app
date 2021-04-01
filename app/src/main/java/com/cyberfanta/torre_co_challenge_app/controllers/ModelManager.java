package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;
import com.cyberfanta.torre_co_challenge_app.models.peoples.Peoples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

    private final Map<String, Job> jobMap = new HashMap<>(20);
    private final Iterator<Map.Entry<String, Job>> jobMapIterator;

    private final Map<String, Bio> bioMap = new HashMap<>(20);
    private final Iterator<Map.Entry<String, Bio>> bioMapIterator;

    private final Map<String, com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> opportunitiesMap = new HashMap<>(20);
    private final Iterator<Map.Entry<String, com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem>> opportunitiesMapIterator;

    private final Map<String, com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> peoplesMap = new HashMap<>(20);
    private final Iterator<Map.Entry<String, com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem>> peoplesMapIterator;

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

        Job job = modelFromConnection.getObject(Job.class, url[0].concat(name));
        jobMap.put(job.getId(), job);
        return job;
    }

    public Job nextJob() {
        if (jobMapIterator.hasNext())
            return jobMapIterator.next().getValue();
        return null;
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

        Bio bio = modelFromConnection.getObject(Bio.class, url[1].concat(name));
        bioMap.put(bio.getPerson().getPublicId(), bio);
        return bio;
    }

    public Bio nextBio() {
        if (bioMapIterator.hasNext())
            return bioMapIterator.next().getValue();
        return null;
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

    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem nextOpportunity(){
        if (opportunitiesMapIterator.hasNext())
            return opportunitiesMapIterator.next().getValue();
        return null;
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

    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem nextPeople(){
        if (peoplesMapIterator.hasNext())
            return peoplesMapIterator.next().getValue();
        return null;
    }

    public void loadPeoples(int size, int offset) throws ConnectionException {
        Peoples peoples = modelFromConnection.postObject(Peoples.class, url[3], size, offset);
        List <com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> resultsItems = peoples.getResults();

        for (com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem resultsItem: resultsItems)
            peoplesMap.put(resultsItem.getUsername(), resultsItem);
    }

    //---
}
