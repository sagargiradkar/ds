package Assignment2;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;

public class Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            ORBorb = ORB.init(args, null);
            POArootPOA =POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            CalculatorImpl calculator = new CalculatorImpl(orb);
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(calculator);
            Calculator href = CalculatorHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = ncRef.to_name("ABC");
            ncRef.rebind(path, href);
            System.out.println("Server ready and waiting...");
            while (true) 
            {
                orb.run();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Server Error: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("Server Exiting...");
    }
}