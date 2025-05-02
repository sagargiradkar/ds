package Assignment7;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("data")

public class SimpleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDummyData() 
    {
        return "Hello, this is dummy data from the web service!";
    }
}