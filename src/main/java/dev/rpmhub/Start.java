package dev.rpmhub;

import dev.rpmhub.model.NosParaKm;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class Start {
    public static double FATOR_CONVERSAO_MILHAS = 0.621371;
    public static double FATOR_CONVERSAO_NOS = 1.852;


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy";
    }

    @GET
    @Path("/no2kmh/{nos}")
    @Produces(MediaType.APPLICATION_JSON)
    public NosParaKm nosParaKm(@PathParam("nos") double nos) {
        return new NosParaKm(nos*FATOR_CONVERSAO_NOS);
    }

    @POST
    @Path("/kmh2mih")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/x-www-form-urlencoded; charset=utf-8")
    public String kmParaMilhas(@FormParam("kmh") double kmh) {
        return String.valueOf(kmh*FATOR_CONVERSAO_MILHAS);
    }


    //usar testes: https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3
}
