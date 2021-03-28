package com.cyberfanta.torre_co_challenge_app.controllers;

import com.cyberfanta.torre_co_challenge_app.exceptions.ConnectionException;
import com.cyberfanta.torre_co_challenge_app.models.bio.Bio;
import com.cyberfanta.torre_co_challenge_app.models.job.Job;
import com.cyberfanta.torre_co_challenge_app.models.opportunities.Opportunities;
import com.cyberfanta.torre_co_challenge_app.models.peoples.Peoples;
import com.google.gson.Gson;

import junit.framework.TestCase;

import org.junit.Assert;

public class ModelFromConnectionTest extends TestCase {
    private final String TAG = "ModelFromConnectionTest";
    private ModelFromConnection modelFromConnection;
    private String[] url;

    public void setUp() throws Exception {
        super.setUp();

        modelFromConnection = new ModelFromConnection();
        url = new String[]
                {
                        "https://torre.bio/api/bios/",                     //https://torre.bio/api/bios/$username
                        "https://torre.co/api/opportunities/",             //https://torre.co/api/opportunities/$id
                        "https://search.torre.co/people/_search/",         //https://search.torre.co/people/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
                        "https://search.torre.co/opportunities/_search/"   //https://search.torre.co/opportunities/_search/?[offset=$offset&size=$size&aggregate=$aggregate]
                };
    }

    public void testGetObject_bio() {
        try {
            Assert.assertSame(modelFromConnection.getObject(Bio.class, url[0].concat("julioleon2004"), "get").getClass(), Bio.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetObject_step_by_step() {
        ConnectionToApi connectionToApi = new ConnectionToApi();
        String json="";
        try {
            json = connectionToApi.getJson(url[0].concat("julioleon2004"), "get");
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        final Gson gson = new Gson();
        final Bio bio = gson.fromJson(json, Bio.class);
        assertEquals("Julio César Alberto León Anhuamán", bio.getPerson().getName());
    }

    public void testGetObject_job() {
        try {
            Assert.assertSame(modelFromConnection.getObject(Job.class, url[1].concat("jw0qXRdx"), "get").getClass(), Job.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetObject_people() {
        try {
            Assert.assertSame(modelFromConnection.getObject(Peoples.class, url[2], "post").getClass(), Peoples.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }

    public void testGetObject_opportunities() {
        try {
            Assert.assertSame(modelFromConnection.getObject(Opportunities.class, url[3], "post").getClass(), Opportunities.class);
        } catch (ConnectionException e) {
            Assert.fail();
        }
    }


//    public void testdebeDevolverJSONEnUnObjeto() {
//        final String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
//        final Gson gson = new Gson();
//        final Empleado empleado = gson.fromJson(json, Empleado.class);
//        assertEquals(46, empleado.getId());
//        assertEquals("Miguel", empleado.getNombre());
//        assertEquals("Autentia", empleado.getEmpresa());
//    }
}

//class Empleado {
//    private final int id;
//    private final String nombre;
//    private final String empresa;
//
//    public Empleado(int id, String nombre, String empresa) {
//        this.id = id;
//        this.nombre = nombre;
//        this.empresa = empresa;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public String getEmpresa() {
//        return empresa;
//    }
//}
