import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CircleImpl extends UnicastRemoteObject implements Circle 
{
    private double PI;
    public CircleImpl() throws RemoteException 
    {
        super();
        PI = 22.0 / 7.0;
    }
    @Override
    public double getArea(int radius) {
        return PI * radius * radius;
    }
    
    @Override
    public double getPerimeter(int radius) {
        return 2 * PI * radius;
    }
}