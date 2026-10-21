/**
 * This class is the struct for the Msg object that will 
 * be used for the Queue.
 * Author: Sean Beckford
 */
import java.util.*;

public class Msg implements Comparable<Msg> {
    private int time;
    private String event;
    private String message;

    public Msg(int time, String event, String message) {
        this.time = time;
        this.event = event;
        this.message = message;
    }

    // Getters
    public int getTime() { return time; }
    public String getEvent() { return event; }
    public String getMessage() { return message; }

    public static Msg parseLine(String line) throws Exception {
        try (Scanner lineScanner = new Scanner(line)) {
            int time = lineScanner.nextInt();
            String event = lineScanner.next();
            String type;
            String message = "";

            if (event.equals("exit")) {
                message = "EXIT";
            }
            else {
                type = lineScanner.next();
                message = lineScanner.next();
            }

            return new Msg(time, event, message);
        }
    }

    public String toString() {
        return "00" + time + ": [" + message + "]";
    }

    @Override 
    public int compareTo(Msg other) {
        return Integer.compare(this.time, other.time);
    }
}