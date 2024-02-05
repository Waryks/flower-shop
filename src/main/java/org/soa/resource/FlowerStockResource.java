package org.soa.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.soa.dto.FlowerDto;
import org.soa.service.FlowerStockService;

@Path("/flowerstocks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FlowerStockResource {
    @Inject
    FlowerStockService flowerStockService;
    @PUT
    @Path("/{flowerId}/{quantity}")
    public Response changeFlowerDetails(@PathParam("flowerId") Long flowerId, @PathParam("quantity") Integer quantity) {
        return Response.accepted(flowerStockService.checkoutFromStock(flowerId,quantity)).build();
    }
}
