package ca.ulaval.glo2003;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Path("")
public class HealthResource {

    @GET
    @Path("health")
    @Produces(MediaType.APPLICATION_JSON)
    public Response health()
    {
        System.out.println("Hello, world!");
        return Response.ok(new HealthResponse("ok")).build();
    }

    @GET
    @Path("products")
    public void products(@QueryParam("sort") String sort, @Context UriInfo uriInfo)
    {
        if(uriInfo.getQueryParameters().getFirst("sort").equals("popular"))
        {
            System.out.println("Popular sort");
        }
        else
        {
            System.out.println("another sort!");
        }
    }

    @GET
    @Path("products2")
    public void products2(@QueryParam("sort") String sort, @HeaderParam ("Content-Type") String content,
                          @PathParam("id") String id)
    {
        if(sort.equals("popular"))
        {
            System.out.println("Popular sort");
        }
        else
        {
            System.out.println("another sort!");
        }

        System.out.println(content);
        System.out.println(id);
    }

    @GET
    @Path("products3/{id}")
    public void products3(@QueryParam("sort") String sort, @HeaderParam ("Content-Type") String content,
                          @PathParam("id") String id)
    {
        if(sort.equals("popular"))
        {
            System.out.println("Popular sort");
        }
        else
        {
            System.out.println("another sort!");
        }

        System.out.println(content);
        System.out.println(id);
    }

    @POST
    @Path("products4")
    @Consumes(MediaType.APPLICATION_JSON)
    public void products4(Product product)
    {
        System.out.println("Title: " + product.getTitle()
                + ", Description: " + product.getDescription()
                + ", Price: " + product.getPrice() + "$, Is sold: "
                + product.isSold());
    }

    @GET
    @Path("products5/{id}")
    public Response products5(@PathParam("id") String id)
    {
        System.out.println("404");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("products6/{id}")
    public Response products6(@PathParam("id") String id)
    {
        System.out.println("404");
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
