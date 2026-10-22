/**
 * This class is the struct for the Msg object that will 
 * be used for the Queue.
 * Author: Sean Beckford
 */
import java.util.*;

public class Msg implements Comparable<Msg> {
    private int time;
    private String event;
    private int repeat;
    private String message;

    public Msg(int time, String event, int repeat, String message) {
        this.time = time;
        this.event = event;
        this.repeat = repeat;
        this.message = message;
    }

    // Getters
    public int getTime() { return time; }
    public String getEvent() { return event; }
    public int getRepeat() { return time; }
    public String getMessage() { return message; }

    public void setRepeat(int repeat) { this.repeat = repeat; }

    public static Msg parseLine(String line) throws Exception {
        try (Scanner lineScanner = new Scanner(line)) {
            int time = lineScanner.nextInt();
            String event = lineScanner.next();
            int repeat = 0;
            String type;
            String message = "";

            if (event.equals("exit")) {
                message = "EXIT";
            }
            else {
                if (lineScanner.hasNextInt()) {
                    repeat = lineScanner.nextInt();
                }
                type = lineScanner.next();
                message = lineScanner.next();
            }

            return new Msg(time, event, repeat, message);
        }
    }

    public String toString() {
        return "[" + message + "]";
    }

    @Override 
    public int compareTo(Msg other) {
        return Integer.compare(this.time, other.time);
    }
}