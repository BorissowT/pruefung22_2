package machine;

import exceptions.EndStateReachedException;
import exceptions.SignNotInGrammatic;

public interface StateMachine {
    void subscribe(StateMachineListener listener);

    void readSign(char c) throws SignNotInGrammatic, EndStateReachedException;

    boolean readCommand(String command) throws SignNotInGrammatic;
}
