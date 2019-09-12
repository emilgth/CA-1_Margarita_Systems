package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.JokeFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("jokes")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/ca1",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE =  JokeFacade.getJokeFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllJokes() {
        return gson.toJson(FACADE.getAllJokes());
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeId(@PathParam("id") Integer id) {
        return gson.toJson(FACADE.getJokeById(id));
    }

    @Path("random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomJoke () {
        return gson.toJson(FACADE.getRandomJoke());
    }
    }

