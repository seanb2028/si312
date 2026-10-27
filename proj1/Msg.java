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
    private int lineNumber;

    public Msg(int time, String event, String message, int lineNumber) {
        this.time = time;
        this.event = event;
        this.message = message;
        this.lineNumber = lineNumber;
    }

    // Getters
    public int getTime() { return time; }
    public String getEvent() { return event; }
    public String getMessage() { return message; }
    public int getLineNumber() { return lineNumber; }

    public String toString() {
        return "[" + message + "]";
    }

    @Override
    public int compareTo(Msg other) {
        int timeComparison = Integer.compare(this.time, other.time);
        if (timeComparison == 0 && !"exit".equals(this.event)) {
            return Integer.compare(this.lineNumber, other.lineNumber);
        }
        return timeComparison;
    }

    public Msg getNext() {
        return null;
    }
}