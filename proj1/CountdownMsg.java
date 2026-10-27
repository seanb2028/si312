/**
 * Author: Sean Beckford
 */

public class CountdownMsg extends RepeatingMsg {
    private int countdown;
    
    public CountdownMsg(int time, String event, int interval, int countdown, String message, int lineNumber) {
        super(time, event, interval, message, lineNumber);
        this.countdown = countdown;
    }

    public int getCountdown() { return countdown; }

    @Override
    public String toString() {
        return "[" + countdown + " : " + this.getMessage() + "]";
    }

    @Override 
    public Msg getNext() {
        if (this.countdown == 1) {
            return null;
        }

        return new CountdownMsg(
            this.getTime() + this.getInterval(),
            this.getEvent(),
            this.getInterval(),
            this.countdown - 1,
            this.getMessage(),
            this.getLineNumber()
        );
    }
}