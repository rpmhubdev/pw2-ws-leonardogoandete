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
    @Path("/nos/{nos}")
    @Produces(MediaType.APPLICATION_JSON)
    public NosParaKm nosParaKm(@PathParam("nos") double nos) {
        NosParaKm nosParaKm = new NosParaKm();
        nosParaKm.setValor(nos*FATOR_CONVERSAO_NOS);
        return nosParaKm;
    }

    @POST
    @Path("/km/{km}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String kmParaMilhas(@PathParam("km") double km) {
        return String.valueOf(km*FATOR_CONVERSAO_MILHAS);
    }
}
