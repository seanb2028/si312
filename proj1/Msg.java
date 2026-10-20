import java.util.Scanner;

/**
 * This class is the struct for the Msg object that will 
 * be used for the Queue.
 * Author: Sean Beckford
 */

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

    public static Msg parseLine(String line) {
        try (Scanner lineScanner = new Scanner(line)) {
            if (lineScanner.hasNextInt()) {
                int time = lineScanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    
        return new Msg(Integer.parseInt(parts[0]), parts[1], parts[3]);
    }

    public String toString() {
        return "00" + time + ": [" + message + "]";
    }

    @Override 
    public int compareTo(Msg other) {
        return Integer.compare(this.time, other.time);
    }
}