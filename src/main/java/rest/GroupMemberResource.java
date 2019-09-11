package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.GroupMemberFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("groupmembers")
public class GroupMemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/ca1",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final GroupMemberFacade FACADE = GroupMemberFacade.getGroupMemberFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Connection established\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        return GSON.toJson(FACADE.getAllGroupMembers());
    }
}

