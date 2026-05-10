package br.com.camilaferreiranas.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventory")
public class InventoryResource {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkInventory() {
        return Response.ok().build();
    }
}
