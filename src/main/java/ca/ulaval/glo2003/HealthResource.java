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
    @Path("products4/{id}")
    public void products4()
    {

    }
}
