/**
 * This class is for converting the file contents into
 * a LinkedListPriorityQueue.
 * Author: Sean Beckford
 */
import java.io.*;
import java.util.*;

public class FileProcessing {
    public PriorityQueue<Msg> readFileAndConvert(String filename) throws Exception {
        try (Scanner file = new Scanner(new File(filename))) {
            PriorityQueue<Msg> pQueue = new LinkedListPriorityQueue<Msg>();

            while (file.hasNextLine()) {
                // Add new Msg object to Linked List pQueue
                pQueue.enqueue(Msg.parseLine(file.nextLine()));
            }
            
            return pQueue;
        }
    }
}