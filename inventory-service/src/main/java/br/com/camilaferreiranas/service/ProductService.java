package br.com.camilaferreiranas.service;

import br.com.camilaferreiranas.model.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8082/products")
public interface ProductService {


    @PATCH
    @Path("/changeQuantity/{id}/value/{quantity}")
    void changeQuantity(@PathParam("quantity") Integer quantity, @PathParam("id") String id);



    @GET
    @Path("/findById/{id}")
    Product findById(@PathParam("id") String id);

}
