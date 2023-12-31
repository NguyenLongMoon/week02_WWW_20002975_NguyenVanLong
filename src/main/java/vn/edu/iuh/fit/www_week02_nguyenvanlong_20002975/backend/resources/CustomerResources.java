package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.services.CustomerServices;

import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResources {
    @Inject
    private CustomerServices customerServices;

    @GET
    @Produces("application/json")
    public Response getAll(@DefaultValue("1") @QueryParam("page") int page) {
        List<Customer> customers = customerServices.getAll(page);

        return Response.ok(customers).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") long id) {
        Optional<Customer> customer = customerServices.findById(id);

        if (customer.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(customer.get()).build();
    }

    @POST
    @Consumes("application/json")
    public Response add(Customer customer) {
        boolean b = customerServices.add(customer);

        if (b)
            return Response.status(Response.Status.CREATED).build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Path("/login")
    public Response login(@FormParam("phone") String phone, @FormParam("password") String password) {
        Optional<Customer> customer = customerServices.login(phone, password);

        if (customer.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(customer.get()).build();
    }

    @PUT
    @Consumes("application/json")
    public Response update(Customer customer) {
        Optional<Boolean> update = customerServices.update(customer);

        if (update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (update.get())
            return Response.ok().build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
