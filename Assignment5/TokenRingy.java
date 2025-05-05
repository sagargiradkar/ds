import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of nodes
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Step 2: Display the ring nodes
        System.out.print("Ring: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("-> 0 (Ring Complete)");

        int ch = 0; // choice to continue or not

        // Step 3: Start communication loop
        do {
            System.out.print("\nEnter Sender: ");
            int sender = sc.nextInt();

            System.out.print("Enter Receiver: ");
            int receiver = sc.nextInt();

            System.out.print("Enter Data to Send: ");
            int data = sc.nextInt();

            // Step 4: Token passing till sender gets it
            System.out.print("Token Passing: ");
            int token = 0;
            for (int i = token; i < sender; i++) {
                System.out.print(i + " -> ");
            }
            System.out.println(sender);

            // Step 5: Sender sends data
            System.out.println("Sender " + sender + " is sending data: " + data);

            // Step 6: Data forwarded to receiver
            for (int i = sender; i != receiver; i = (i + 1) % n) {
                System.out.println("Data " + data + " forwarded by " + i);
            }

            // Step 7: Receiver gets data
            System.out.println("Receiver " + receiver + " received the data: " + data + "\n");

            // Update token position
            token = sender;

            // Step 8: Ask user to continue
            System.out.print("Do you want to send data again? (1 = Yes / 0 = No): ");
            ch = sc.nextInt();

        } while (ch == 1);
    }
}
