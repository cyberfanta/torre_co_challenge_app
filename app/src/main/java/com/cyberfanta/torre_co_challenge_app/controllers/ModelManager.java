package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;
import com.cyberfanta.torre_co_challenge_app.models.peoples.Peoples;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModelManager {

    private final String[] url = new String[]{
            "https://torre.co/api/opportunities/",  //https://torre.co/api/opportunities/$id
            "https://torre.bio/api/bios/",  //https://torre.bio/api/bios/$username
            "https://search.torre.co/opportunities/_search/", //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
            "https://search.torre.co/people/_search/"  //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
    };
    private final ModelFromConnection modelFromConnection = new ModelFromConnection();

    private final static Map<String, Job> jobMap = new LinkedHashMap<>(0);
    private int jobMapIterator = 0;

    private final static Map<String, Bio> bioMap = new LinkedHashMap<>(0);
    private int bioMapIterator = 0;

    private final static Map<String, com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> opportunitiesMap = new LinkedHashMap<>(0);
    private int opportunitiesMapIterator = 0;

    private final static Map<String, com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> peoplesMap = new LinkedHashMap<>(0);
    private int peoplesMapIterator = 0;

    //Getters
    //-- Job
    public Job getJob(String name) throws ConnectionException {
        if (!jobMap.containsKey(name))
            loadJob(name);

        return jobMap.get(name);
    }

    public Job nextJob() throws ConnectionException {
        if (jobMapIterator < jobMap.size())
            return (Job) jobMap.values().toArray()[jobMapIterator++];

        throw new ConnectionException("NEED_LOAD_MORE_JOBS");
    }

    public void loadJob(String name) throws ConnectionException {
        if (!jobMap.containsKey(name)) {
            Job job = modelFromConnection.getObject(Job.class, url[0].concat(name));
            try {
                BitmapFromConnection.getBitmap(job.getId(), job.getSerpTags().getHiringOrganization().getLogo());
            } catch (IOException ignored) {
            }
            jobMap.put(job.getId(), job);
        }
    }

    //-- Bio
    public Bio getBio(String name) throws ConnectionException {
        if (!bioMap.containsKey(name))
            loadBio(name);

        return bioMap.get(name);
    }

    public Bio nextBio() throws ConnectionException {
        if (bioMapIterator < bioMap.size())
            return (Bio) bioMap.values().toArray()[bioMapIterator++];

        throw new ConnectionException("NEED_LOAD_MORE_BIOS");
    }

    public void loadBio(String name) throws ConnectionException{
        if (!bioMap.containsKey(name)) {
            Bio bio = modelFromConnection.getObject(Bio.class, url[1].concat(name));
            try {
                BitmapFromConnection.getBitmap(bio.getPerson().getPublicId(), bio.getPerson().getPicture());
                if (bio.getExperiences().size() > 1)
                    for (int i = 0; i < bio.getExperiences().size(); i++) {
                        for (int j = 0; j < bio.getExperiences().get(i).getOrganizations().size(); j++) {
                            BitmapFromConnection.getBitmap(bio.getExperiences().get(i).getOrganizations().get(j).getName(), bio.getExperiences().get(i).getOrganizations().get(j).getPicture());
                        }
                    }
                if (bio.getEducation().size() > 1)
                    for (int i = 0; i < bio.getEducation().size(); i++) {
                        for (int j = 0; j < bio.getEducation().get(i).getOrganizations().size(); j++) {
                            BitmapFromConnection.getBitmap(bio.getEducation().get(i).getOrganizations().get(j).getName(), bio.getEducation().get(i).getOrganizations().get(j).getPicture());
                        }
                    }
            } catch (IOException ignored) {
            }
            bioMap.put(bio.getPerson().getPublicId(), bio);
        }
    }

    //-- Opportunities
    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem getOpportunity(String id) throws ConnectionException {
        if (opportunitiesMap.containsKey(id))
            return opportunitiesMap.get(id);

        throw new ConnectionException("OPPORTUNITY_NOT_LOADED");
    }

    public com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem nextOpportunity() throws ConnectionException {
        if (!(opportunitiesMapIterator < opportunitiesMap.size()))
            loadOpportunities(20, opportunitiesMap.size());

        return (com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem) opportunitiesMap.values().toArray()[opportunitiesMapIterator++];
    }

    public void loadOpportunities(int size, int offset) throws ConnectionException {
        Opportunities opportunities = modelFromConnection.postObject(Opportunities.class, url[2], size, offset);
        List <com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem> resultsItems = opportunities.getResults();

        if (resultsItems == null) throw new ConnectionException("Unexpected Error");
        for (com.cyberfanta.torre_co_challenge_app.models.opportunities.ResultsItem resultsItem: resultsItems) {
            try {
                if (resultsItem.getOrganizations().size() > 0)
                    BitmapFromConnection.getBitmap(resultsItem.getId(), resultsItem.getOrganizations().get(0).getPicture());
            } catch (IOException ignored) {
            }
            opportunitiesMap.put(resultsItem.getId(), resultsItem);
        }
    }

    //-- Peoples
    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem getPeople(String userName) throws ConnectionException {
        if (peoplesMap.containsKey(userName))
            return peoplesMap.get(userName);

        throw new ConnectionException("PERSON_NOT_LOADED");
    }

    public com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem nextPeople() throws ConnectionException {
        if (!(peoplesMapIterator < peoplesMap.size()))
            loadPeoples(20, peoplesMap.size());

        return (com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem) peoplesMap.values().toArray()[peoplesMapIterator++];
    }

    public void loadPeoples(int size, int offset) throws ConnectionException {
        Peoples peoples = modelFromConnection.postObject(Peoples.class, url[3], size, offset);
        List <com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem> resultsItems = peoples.getResults();

        for (com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem resultsItem: resultsItems) {
            try {
                BitmapFromConnection.getBitmap(resultsItem.getUsername(), resultsItem.getPicture());
            } catch (IOException ignored) {
            }
            peoplesMap.put(resultsItem.getUsername(), resultsItem);
        }

        for (com.cyberfanta.torre_co_challenge_app.models.peoples.ResultsItem resultsItem: resultsItems)
            peoplesMap.put(resultsItem.getUsername(), resultsItem);
    }
}
