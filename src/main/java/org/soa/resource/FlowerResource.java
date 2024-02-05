package org.soa.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.soa.dto.FlowerDto;
import org.soa.service.FlowerService;

import java.net.URI;

@Path("/flowers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FlowerResource {
    @Inject
    FlowerService flowerService;
    @GET
    @Path("/{flowerId}")
    public Response findFlowerDetails(@PathParam("flowerId") Long flowerId) {
        return Response.ok(flowerService.getFlowerDetails(flowerId)).build();
    }

    @POST
    @Path("/")
    public Response createFlower(FlowerDto flowerDto) {
        return Response.created(URI.create(flowerService.createFlower(flowerDto).toString())).build();
    }

    @PUT
    @Path("/{flowerId}")
    public Response changeFlowerDetails(@PathParam("flowerId") Long flowerId, FlowerDto flowerDto) {
        flowerService.changeFlowerDetails(flowerId, flowerDto);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{flowerId}")
    public Response deleteFlower(@PathParam("flowerId") Long flowerId) {
        flowerService.deleteFlower(flowerId);
        return Response.accepted().build();
    }

}
