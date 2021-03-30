package com.cyberfanta.torre_co_challenge_app.controllers;

import android.util.Log;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;
import com.cyberfanta.torre_co_challenge_app.models.peoples.Peoples;

import java.util.ArrayList;

public class ModelManager {
    private final String TAG = "ModelManager";

    private final String[] url = new String[]{
            "https://torre.co/api/opportunities/",  //https://torre.co/api/opportunities/$id
            "https://torre.bio/api/bios/",  //https://torre.bio/api/bios/$username
            "https://search.torre.co/opportunities/_search/", //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
            "https://search.torre.co/people/_search/"  //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
    };
    private final ModelFromConnection modelFromConnection = new ModelFromConnection();

    private final Integer[] index = new Integer[]{0, 0, 0, 0};

    private final ArrayList<Job> jobArrayList = new ArrayList<>(0);
    private final ArrayList<Bio> bioArrayList = new ArrayList<>(0);
    private final ArrayList<com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> opportunitiesArrayList = new ArrayList<>(0);
    private final ArrayList<com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> peoplesArrayList = new ArrayList<>(0);

    public ModelManager(){

    }

    //Getters
    //-- Job
    public ArrayList<Job> getJobArrayList() {
        return jobArrayList;
    }

    public Job getJob (int i){
        return jobArrayList.get(i);
    }

    public Job nextJob (){
        return jobArrayList.get(index[0]++);
    }

    public void loadJob (String name) throws ConnectionException {
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
        return opportunitiesArrayList.get(index[2]++);
    }

    public void loadOpportunities (int size, int offset) throws ConnectionException {
        Log.i(TAG, "pasó");
        Opportunities opportunities = modelFromConnection.postObject(Opportunities.class, url[2], size, offset);
        Log.i(TAG, opportunities.toString());

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
        return peoplesArrayList.get(index[3]++);
    }

    public void loadPeoples (int size, int offset) throws ConnectionException {
        Peoples peoples = modelFromConnection.postObject(Peoples.class, url[3], size, offset);
        peoplesArrayList.addAll(peoples.getResults());
    }

    //---
}
