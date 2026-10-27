/**
 * This class is for converting the file contents into
 * a LinkedListPriorityQueue.
 * Author: Sean Beckford
 */
import java.io.*;
import java.util.*;

public class FileProcessing {
    public Msg parseLine(String line, int lineNum) {
        try (Scanner lineScanner = new Scanner(line)) {
            int time = lineScanner.nextInt();
            String event = lineScanner.next();

            if (event.equals("exit")) {
                return new Msg(time, event, "EXIT", lineNum);
            }

            int interval = 0;
            int countdown = 0;
            
            if (event.equals("countdown")) {
                interval = lineScanner.nextInt();
                countdown = lineScanner.nextInt();
            } else if (event.equals("repeating")) {
                interval = lineScanner.nextInt();
            }

            String type = lineScanner.next();
            String message = lineScanner.next();

            if (event.equals("countdown")) {
                return new CountdownMsg(time, event, interval, countdown, message, lineNum);
            } else if (event.equals("repeating")) {
                return new RepeatingMsg(time, event, interval, message, lineNum);
            } else {
                return new Msg(time, event, message, lineNum);
            }
        }
    }

    public PriorityQueue<Msg> readFileAndConvert(String filename) throws Exception {
        try (Scanner file = new Scanner(new File(filename))) {
            PriorityQueue<Msg> pQueue = new LinkedListPriorityQueue<Msg>();

            while (file.hasNextLine()) {
                // Add new Msg object to Linked List pQueue
                pQueue.enqueue(parseLine(file.nextLine(), pQueue.size()));
            }
            
            return pQueue;
        }
    }
}