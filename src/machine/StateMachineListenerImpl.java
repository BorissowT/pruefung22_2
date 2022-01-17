package machine;

import java.util.ArrayList;
import java.util.List;

public class StateMachineListenerImpl implements StateMachineListener {
    private boolean initialStateReached = false;
    private boolean endStateReached = false;
    private List<Character> line = new ArrayList<Character>();

    public boolean isEndStateReached() {
        return endStateReached;
    }

    @Override
    public void initialStateReached() {
        System.out.println("initialStateReached");
        this.initialStateReached = true;
    }

    @Override
    public void endStateReached() {
        System.out.println("endStateReached");
        this.endStateReached = true;
    }

    @Override
    public void addSignToLine(char sign) {
        this.line.add(sign);
    }
}
