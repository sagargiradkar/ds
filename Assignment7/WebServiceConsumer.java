package Assignment7;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class WebServiceConsumer 
{
    public static void main(String[] args) 
    {
        Client client = ClientBuilder.newClient();
        String response = client.target("http://localhost:8080/<your_project_name>/data").request(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Response from web service: " + response);
        client.close();
    }
}