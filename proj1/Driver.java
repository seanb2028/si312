/**
 * Main class for the program.
 * Author: Sean Beckford
 */
import java.io.*;
import java.util.*;

public class Driver {
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

        // Initiate linked list based on file data
        FileProcessing fp = new FileProcessing();
        PriorityQueue<Msg> pQueue = fp.readFileAndConvert(clock ? args[1] : args[0]);

        // Start simulation
        Simulation s = new Simulation(pQueue);
        s.runSimulation();
    }
}
