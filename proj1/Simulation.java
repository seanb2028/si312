import java.util.PriorityQueue;

/**
 * Author: Sean Beckford
 */
public class Simulation {
    private PriorityQueue<Msg> pQueue;

    public Simulation(PriorityQueue<Msg> pQueue) {
        this.pQueue = pQueue;
    }

    public void runSimulation() {
        System.out.println("Simulation");
        while (pQueue.size() > 0) {
            Msg m = pQueue.dequeue();
            System.out.println(m.toString());
        } 
        System.out.println("Goodbye");
    }
}