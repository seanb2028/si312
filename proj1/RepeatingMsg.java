/**
 * Author: Sean Beckford
 */

public class RepeatingMsg extends Msg {
    private int interval;
    
    public RepeatingMsg(int time, String event, int interval, String message, int lineNumber) {
        super(time, event, message, lineNumber);
        this.interval = interval;
    }

    public int getInterval() { return interval; }

    @Override
    public Msg getNext() {
        return new RepeatingMsg(
            this.getTime() + this.interval,
            this.getEvent(),
            this.interval,
            this.getMessage(),
            this.getLineNumber()
        );
    }
}