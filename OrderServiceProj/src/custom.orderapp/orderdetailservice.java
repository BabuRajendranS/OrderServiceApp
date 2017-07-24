package custom.orderapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/orderapp")
@Produces("text/plain")
public class orderdetailservice {
    public orderdetailservice() {
    }

    @GET
    public String getData(@QueryParam("ordernumber") int ordernumber, @QueryParam("offset") int offset) 
    {

        // Provide method implementation.
        // TODO
        System.out.println("ordernumber : " + ordernumber);
        System.out.println("offset : " + offset);
        order orderobj = new order();
        String orderdetails = orderobj.getorderinfo(ordernumber, offset);
        return orderdetails;
    }
}
