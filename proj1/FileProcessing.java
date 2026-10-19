import java.util.PriorityQueue;

/**
 * This class is for converting the file contents into
 * a LinkedListPriorityQueue.
 * Author: Sean Beckford
 */
public class FileProcessing {
    public PriorityQueue<Msg> readFileAndConvert(String filename) {
        PriorityQueue<Msg> pQueue = new LinkedListPriorityQueue<Msg>();

        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNextLine()) {
                // Add new Msg object to Linked List pQueue
                pQueue.enqueue(Msg.parseLine(file.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Error: File '" + filename + "' not found!");
        }

        return pQueue;
    }
}