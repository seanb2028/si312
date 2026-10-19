/**
 * Main class for the program.
 * Author: Sean Beckford
 */
import java.io.*;
import java.util.*;

public class Driver {
    private PriorityQueue<Msg> pQueue;

    public Driver() {
        this.pQueue = new LinkedListPriorityQueue<Msg>();
    }

    public void readFileAndConvert(String filename) {
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNextLine()) {
                // Add new Msg object to Linked List pQueue
                pQueue.enqueue(Msg.parseLine(file.nextLine()));
            }
        } catch (IOException e ) {
            System.out.println("Error: File '" + filename + "' not found!");
        }
    }

    public void runSimulation() {
        System.out.println("Simulation");
        while (pQueue.size() > 0) {
            Msg m = pQueue.dequeue();
            System.out.println(m.toString());
        } 
        System.out.println("Goodbye");
    }

    public static void main(String []args) {
        boolean clock = false;

        // Check command line usage
        if (args.length == 0 || (args.length > 1 && !args[0].equals("-c"))) {
            System.out.println("usage: java Driver [-c] <file>");
            System.exit(1);
        }
        else if (args.length > 1 && args[0].equals("-c")) {
            clock = true;
        }
        
        Driver d = new Driver();

        // Sort Linked List
        d.readFileAndConvert(clock ? args[1] : args[0]);

        // Start simulation
        d.runSimulation();
    }
}
