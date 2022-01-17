package machine;
import exceptions.EndStateReachedException;
import exceptions.SignNotInGrammatic;

import java.util.StringTokenizer;

public class StateMachineImpl implements StateMachine {
    private StateMachineListener listener;

    @Override
    public void subscribe(StateMachineListener listener) {
        this.listener = listener;
    }

    @Override
    public void readSign(char sign) throws SignNotInGrammatic, EndStateReachedException {
        setInitialState();
        checkIfEndStateReached();
        switch (sign){
            case 'A' -> {
                this.listener.addSignToLine(sign);
            }
            case 'B' -> {
                this.listener.addSignToLine(sign);
                this.listener.endStateReached();
            }
            default -> {
                throw new SignNotInGrammatic("Sign not in grammatic");
            }
        }
    }

    private void checkIfEndStateReached() throws EndStateReachedException {
        if(this.listener.isEndStateReached()) {
            throw new EndStateReachedException("End state reached");
        }
    }

    private void setInitialState() {
        if(this.listener != null) {
            this.listener.initialStateReached();
        }
    }

    @Override
    public boolean readCommand(String command) throws SignNotInGrammatic {
        StringTokenizer st = new StringTokenizer(command);
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
            if (st.nextToken() == "error")
                throw new SignNotInGrammatic("Error");
        }

    return true;
    }
}
