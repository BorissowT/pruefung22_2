package machine;

public interface StateMachineListener {
    void initialStateReached();
    void endStateReached();
    void addSignToLine(char sign);

    boolean isEndStateReached();
}
