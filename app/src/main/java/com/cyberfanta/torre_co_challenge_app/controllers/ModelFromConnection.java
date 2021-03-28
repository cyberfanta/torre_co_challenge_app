package com.cyberfanta.torre_co_challenge_app.controllers;

import android.util.Log;

import com.cyberfanta.torre_co_challenge.logics.exceptions.ConnectionException;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class ModelFromConnection {






    public String getJson (String url) throws ConnectionException {

        //Json Root
        JsonFactory factory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper(factory);

        JsonNode jsonNode = objectMapper.readTree(responseJSON);
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = jsonNode.fields();
        Vector<Map.Entry<String, JsonNode>> fields = new Vector<>(0);

        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            fields.add(field); //Json Root Parsed
        }

        //Object person
        persons = JSONtoClass(fields.elementAt(0).getValue().toString(), Persons.class);
        Log.i(null, "original json: " + fields.elementAt(0).getValue().toString());
        Log.i(null, "person: " + persons.toString());

        jsonNode = objectMapper.readTree(fields.elementAt(0).getValue().toString());
        fieldsIterator = jsonNode.fields();
        Vector<Map.Entry<String, JsonNode>> persons_fields = new Vector<>(0);

        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            Log.i(null, "Key: " + field.getKey() + "\tValue:" + field.getValue());
            if (field.getKey().equals("links"))
                persons_fields.add(field); //Json person Parsed
            if (field.getKey().equals("location"))
                persons_fields.add(field); //Json person Parsed
        }

        Locations locations = JSONtoClass(persons_fields.elementAt(1).getValue().toString(), Locations.class);
        Log.i(null, "locations: " + locations.toString());
        persons.setLocations(locations);

        Log.i(null, "persons_fields[0]: " + persons_fields.elementAt(0).getValue().toString().substring(1, persons_fields.elementAt(0).getValue().toString().length() - 1));

        String regex = "";
        regex = regex.concat("\\},\\{");

        String[] responseJSONList = persons_fields.elementAt(0).getValue().toString().substring(1, persons_fields.elementAt(0).getValue().toString().length() - 1).split(regex);
        responseJSONList[0] = responseJSONList[0].substring(1);
        responseJSONList[responseJSONList.length - 1] = responseJSONList[responseJSONList.length - 1].substring(0, responseJSONList[responseJSONList.length - 1].length() - 1);

        for (String field : responseJSONList) {
            Log.i(null, "field: " + field);
            Links links = JSONtoClass("{" + field + "}", Links.class);
            persons.addLinks(links); //Json links parsing
            Log.i(null, "links: " + links.toString());
        }
    }
}
