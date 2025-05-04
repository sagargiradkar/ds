import java.util.Scanner;

public class RingAlgorithm {

    Scanner sc;
    Process[] processes;
    int n;

    // initialize Scanner class object in constructor
    public RingAlgorithm() {
        sc = new Scanner(System.in);
    }

    // create ring() method for initializing the ring
    public void ring() {

        // get input from the user for processes
        System.out.print("Enter total number of processes: ");
        n = sc.nextInt();

        // initialize processes array
        processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(i);
        }
    }

    // create election() method for electing process
    public void performElection() {

        // we use the sleep() method to stop the execution of the current thread
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // show failed process
        System.out.println("Process " + processes[getMaxValue()].id + " fails");

        // change status to Inactive of the failed process
        processes[getMaxValue()].status = "Inactive";

        int idOfInitiator = 0;
        boolean overStatus = true;

        while (overStatus) {

            // the election message is passed in a ring fashion
            System.out.println();
            int nextProcess = (idOfInitiator + 1) % n;

            if (processes[nextProcess].status == "active") {
                System.out.println("Process " + idOfInitiator + " passes Election(" + idOfInitiator + ") message to Process " + nextProcess);
            }

            // the next process passes the election message back to the initiator
            if (processes[nextProcess].status == "active" && nextProcess == getMaxValue()) {
                System.out.println("Process " + nextProcess + " becomes the coordinator.");
                overStatus = false;
                break;
            }

            idOfInitiator = nextProcess;
        }
    }

    // create getMaxValue() method that returns index of max process
    public int getMaxValue() {
        int mxId = -99;
        int mxIdIndex = 0;
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].status == "active" && processes[i].id > mxId) {
                mxId = processes[i].id;
                mxIdIndex = i;
            }
        }
        return mxIdIndex;
    }

    public static void main(String[] args) {

        RingAlgorithm ring = new RingAlgorithm();
        ring.ring();
        ring.performElection();
    }
}
