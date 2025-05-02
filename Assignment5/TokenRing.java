package Assignment5;
import java.util.*;
public class TokenRing 
{
    private int n;
    private int[] state;
    private boolean token;

    public TokenRing(int n) 
    {
        this.n = n;
        state = new int[n];
    }

    public void run() 
    {
        for (int i = 0; i < n; i++) 
        {
            state[i] = 0; // not in critical section
        }
        int curr = new Random().nextInt(n);
        token = true;
        while (true) 
        {
            if (token) 
            {
                if (state[curr] == 0) 
                { // not in critical section
                    enterCritical(curr);
                    state[curr] = 1; // in critical section
                } 
                else 
                { // in critical section
                    exitCritical(curr);
                    state[curr] = 0; // not in critical section
                    curr = (curr + 1) % n; // pass the token
                    token = true;
                }
            }
        }
    }

    private void enterCritical(int id) 
    {
        System.out.println("Process " + id + " enters critical section");
    }
    private void exitCritical(int id) 
    {
        System.out.println("Process " + id + " exits critical section");
        token = false;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Processes To Be Created: ");
        int n = sc.nextInt();
        sc.close();
        TokenRing tr = new TokenRing(n); // Instantiate a ring of n processes
        tr.run(); // Run the token ring algorithm
    }
 }