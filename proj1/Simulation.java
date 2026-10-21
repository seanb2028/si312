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
        this.currentTime = 0;
    }

    public void runClock(int time) {
        for (int i = currentTime; i < time; i++) {
            if (i < 10) {  System.out.print("00"); }
            else if (i < 100) { System.out.print("0"); }
            System.out.println(i + ": ");
        }
        currentTime = time + 1;
    }

    public void runSimulation(boolean cOption) {
        System.out.println("Simulation");
        while (pQueue.size() > 0) {
            Msg m = pQueue.dequeue();
            // Run the clock until time, k (as mentioned in the spec.)
            if (!cOption) { runClock(m.getTime()); }
            System.out.println(m.toString());
            if (m.getEvent().equals("exit")) { break; }
        } 
        System.out.println("Goodbye");
    }
}