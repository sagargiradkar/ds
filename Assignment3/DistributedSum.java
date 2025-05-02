package Assignment3;
import mpi.*;

public class DistributedSum {
    public static void main(String[] args) throws MPIException 
    {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank(); 
        int size = MPI.COMM_WORLD.Size(); 
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        int n = array.length; 
        int local_n = n / size;
        int remainder = n % size; 

        int[] local_array = new int[local_n + (rank < remainder ? 1 : 0)]; 
        int offset = rank * local_n + Math.min(rank, remainder); 
        for (int i = 0; i < local_array.length; i++) 
        {
            local_array[i] = array[offset + i];
        }

        int local_sum = 0; 
        for (int i = 0; i < local_array.length; i++) 
        {
            local_sum += local_array[i];
        }
        
        int[] global_sums = new int[size]; 
        MPI.COMM_WORLD.Allgather(new int[]{local_sum}, 0, 1, MPI.INT, global_sums, 0, 1,MPI.INT); 
        if (rank == 0) 
        { 
            System.out.println("Number of Processes Entered: "+ size);
            System.out.println("\nIntermediate Sums:");
            int sum = 0;
            for (int i = 0; i < size; i++) 
            {
                sum += global_sums[i];
                System.out.println("Process " + i + ": " + global_sums[i]);
            }
            System.out.println("\nTotal Sum: " + sum);
        }
        MPI.Finalize();
    }
}