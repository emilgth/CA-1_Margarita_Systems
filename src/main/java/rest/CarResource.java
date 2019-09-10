package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.RenameMe;
import facades.CarFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("car")
public class CarResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV,
                EMF_Creator.Strategy.CREATE);
    private static final CarFacade FACADE =  CarFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCarCount() {
        long count = FACADE.getCarEntityCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCars() {
        return GSON.toJson(FACADE.getAllCars());
    }
}
