package ca.ulaval.glo2003;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    @Path("products6")
    public Response products6()
    {
        return Response.status(200).header("a header", "with a message").build();
    }

    @GET
    @Path("products7")
    @Produces(MediaType.APPLICATION_JSON)
    public Response products7()
    {
        Product product = new Product("pro1", "first pro", 10.00f, true );
        return Response.ok(product).build();
    }

    @GET
    @Path("products8")
    @Produces(MediaType.APPLICATION_JSON)
    public Response products8()
    {
        List<Product> products = new ArrayList<Product>()
                {{
                        add(new Product("pro1", "first pro", 10.00f, true ));
                        add(new Product("pro2", "second pro", -10.00f, true ));
                        add(new Product("pro3", "third pro", 20.00f, false ));
                }};

        return Response.ok(products).build();
    }

    @GET
    @Path("products9")
    @Produces(MediaType.APPLICATION_JSON)
    public Response products9()
    {
        LocalDateTime dateTime = LocalDateTime.now();
        ComplexProduct product = new ComplexProduct("pro1", "first pro", 10.00f, true, dateTime );
        return Response.ok(product).build();
    }
}
