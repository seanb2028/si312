/**
 * Author: Sean Beckford
 */
import java.io.*;
import java.util.*;

public class Simulation {
    private PriorityQueue<Msg> pQueue;
    private int currentTime;

    public Simulation(PriorityQueue<Msg> pQueue) {
        this.pQueue = pQueue;
        this.currentTime = 1;
    }

    public String formattedTime(int time) {
        return String.format("%03d: ", time); // This formats an integer with zero-padding to a min width of 3 digits
    }

    // Run the clock until time, k (as mentioned in the spec.)
    public void runClock(int time) {
        for (int i = currentTime; i < time; i++) {
            System.out.println(formattedTime(i));
        }
        currentTime = time;
    }

    public void runSimulation(boolean cOption) {
        System.out.println("Simulation");
        
        int lastTime = 0;        
        while (pQueue.size() > 0) {
            Msg m = pQueue.dequeue();

            if (m.getTime() != lastTime) {
                if (lastTime != 0) {
                    System.out.println();
                }
                if (!cOption) {
                    runClock(m.getTime());
                }
                System.out.print(formattedTime(m.getTime()) + m.toString());

                lastTime = m.getTime();
                currentTime = m.getTime() + 1;
            }
            else {
                System.out.print(m.toString());
            }
            
            // Exit message (if one of the Msg objects)
            if (m.getEvent().equals("exit")) { 
                break; 
            }
            
            Msg next = m.getNext();
            if (next != null) {
                pQueue.enqueue(next);
            }
        }
        System.out.println(); 
        System.out.println("Goodbye");
    }
}