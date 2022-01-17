package machine;

import exceptions.EndStateReachedException;
import exceptions.SignNotInGrammatic;
import machine.StateMachineListenerImpl;
import org.junit.Test;

public class MachineTests {

    @Test
    public void testSuccessful() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('A');
        machine.readSign('A');
        machine.readSign('A');
        machine.readSign('B');
    }

    @Test
    public void testSuccessful2() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('A');
        machine.readSign('B');
    }

    @Test
    public void testSuccessful3() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('B');
    }

    @Test(expected = SignNotInGrammatic.class)
    public void testWrongSign() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('D');
    }

    @Test(expected = SignNotInGrammatic.class)
    public void testWrongSign1() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('1');
    }

    @Test(expected = EndStateReachedException.class)
    public void testEndStateReached() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('A');
        machine.readSign('B');
        machine.readSign('B');
    }

    @Test(expected = EndStateReachedException.class)
    public void testEndStateReached2() throws SignNotInGrammatic, EndStateReachedException {
        StateMachineListener listener = new StateMachineListenerImpl();
        StateMachine machine = new StateMachineImpl();
        machine.subscribe(listener);

        machine.readSign('A');
        machine.readSign('B');
        machine.readSign('A');
    }


}
