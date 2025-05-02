package Assignment2;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
public class Client {
    public static void main(String[] args) 
    {
        try 
        {
            ORBorb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator calculator = CalculatorHelper.narrow(ncRef.resolve_str("ABC"));
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to addition system:");
            while (true) 
            {
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("Press any key to exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                if (choice == 5) {
                    break;
                }
                System.out.print("Enter first no: ");
                double x = sc.nextDouble();
                System.out.print("Enter second no: ");
                double y = sc.nextDouble();
                if (choice == 1) {
                    System.out.println("Ans = " + x + " + " + y + " = " +calculator.add(x, y));
                }
                else if (choice == 2) 
                {
                    System.out.println("Ans = " + x + "- " + y + " = " +calculator.subtract(x, y));
                } 
                else if (choice == 3) {
                    System.out.println("Ans = " + x + " * " + y + " = " +calculator.multiply(x, y));
                } 
                else if (choice == 4) {
                    System.out.println("Ans = " + x + " / " + y + " = " +calculator.divide(x, y));
                }
                System.out.println("---------------------------------------------------\n");
            }
            sc.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Client Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}