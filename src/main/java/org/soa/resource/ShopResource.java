package org.soa.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.soa.dto.ShopDto;
import org.soa.service.ShopService;

import java.net.URI;

@Path("/shops")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ShopResource {
    @Inject
    ShopService shopService;
    @GET
    @Path("/{shopId}")
    public Response findShop(@PathParam("shopId") Long shopId) {
        return Response.ok(shopService.getShop(shopId)).build();
    }

    @POST
    @Path("/")
    public Response createShop(ShopDto shopDto) {
        return Response.created(URI.create(shopService.createShop(shopDto).toString())).build();
    }
}
