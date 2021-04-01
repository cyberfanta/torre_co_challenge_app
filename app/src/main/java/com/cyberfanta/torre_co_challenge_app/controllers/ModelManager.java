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
import java.util.Map;
import java.util.Set;

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

    private final Map<String, Job> jobArrayList = new HashMap<>(20);
    private Iterator<Map.Entry<String, Job>> jobArrayListIterator;

    private final Map<String, Bio> bioArrayList = new HashMap<>(20);
    private Iterator<Map.Entry<String, Bio>> bioArrayListIterator;

    private final ArrayList<com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> opportunitiesArrayList = new ArrayList<>(20);
    private final ArrayList<com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> peoplesArrayList = new ArrayList<>(20);

    public ModelManager(){
        TAG = "ModelManager";

        jobArrayListIterator = jobArrayList.entrySet().iterator();
        bioArrayListIterator = bioArrayList.entrySet().iterator();
    }

    //Getters
    //-- Job
//    public ArrayList<Job> getJobArrayList() {
//        return jobArrayList;
//    }

//    public Job getJob (int i){
//        return jobArrayList.get(i);
//    }

//    public Job nextJob (){
//        return jobArrayList.get(index[0]++);
//    }

    public Job loadJob (String name) throws ConnectionException {
        jobArrayList.add(modelFromConnection.getObject(Job.class, url[0].concat(name)));
    }

    //-- Bio
    public ArrayList<Bio> getBioArrayList() {
        return bioArrayList;
    }

    public Bio getBio (int i){
        return bioArrayList.get(i);
    }

    public Bio nextBio (){
        return bioArrayList.get(index[1]++);
    }

    public void loadBio (String name) throws ConnectionException {
        bioArrayList.add(modelFromConnection.getObject(Bio.class, url[1].concat(name)));
    }

    //-- Opportunities
    public ArrayList<com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> getOpportunitiesArrayList() {
        return opportunitiesArrayList;
    }

    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem getOpportunities (int i){
        return opportunitiesArrayList.get(i);
    }

    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem nextOpportunities (){
        if (index[2] < opportunitiesArrayList.size())
            return opportunitiesArrayList.get(index[2]++);
        else
            return null;
    }

    public void loadOpportunities (int size, int offset) throws ConnectionException {
        Opportunities opportunities = modelFromConnection.postObject(Opportunities.class, url[2], size, offset);
        opportunitiesArrayList.addAll(opportunities.getResults());
    }

    //-- Peoples
    public ArrayList<com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> getPeoplesArrayList() {
        return peoplesArrayList;
    }

    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem getPeoples (int i){
        return peoplesArrayList.get(i);
    }

    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem nextPeoples (){
        if (index[3] < peoplesArrayList.size())
            return peoplesArrayList.get(index[3]++);
        else
            return null;
    }

    public void loadPeoples (int size, int offset) throws ConnectionException {
        Peoples peoples = modelFromConnection.postObject(Peoples.class, url[3], size, offset);
        peoplesArrayList.addAll(peoples.getResults());
    }

    //---
}
