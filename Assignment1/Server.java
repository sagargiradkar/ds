import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    public static void main(String[] args) 
    {
        try 
        {
            System.out.println("Server started...");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(4000);
            Circle stub = new CircleImpl();
            registry.rebind("rmi://localhost:4000/circle", stub);
        } 
        catch (Exception e) 
        {
            System.out.println("Server error: " + e);
        }
    }
}