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

    // Run the clock until time, k (as mentioned in the spec.)
    public void runClock(int time) {
        for (int i = currentTime; i <= time; i++) {
            if (i < 10) {  System.out.print("00"); }
            else if (i < 100) { System.out.print("0"); }
            System.out.println(i + ": ");
        }

        currentTime = time;
    }

    public void runSimulation(boolean cOption) {
        System.out.println("Simulation");
        while (pQueue.size() > 0) {
            Msg m = pQueue.dequeue();

            if (!cOption && m.getTime() != currentTime) { runClock(m.getTime()); }
            else if (!cOption) { System.out.print(" " + m.toString()); }
            System.out.print(m.toString());
            
            if (m.getEvent().equals("exit")) { break; }
            else if (m.getEvent().equals("repeating")) {
                pQueue.enqueue(new Msg(currentTime + m.getRepeat(), "repeating", m.getRepeat(), m.getMessage()));
            }
        } 
        System.out.println("Goodbye");
    }
}