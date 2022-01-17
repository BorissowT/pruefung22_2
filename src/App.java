import console.IConsole;
import console.impl.Console;
import exceptions.EndStateReachedException;
import exceptions.SignNotInGrammatic;
import machine.StateMachine;
import machine.StateMachineImpl;
import machine.StateMachineListener;
import machine.StateMachineListenerImpl;

public class App {
	public static void main(String[] args) {
		StateMachine Machine = new StateMachineImpl();
		StateMachineListener listener = new StateMachineListenerImpl();
		IConsole console = new Console();

		Machine.subscribe(listener);
		while (true) {
			try {
				char sign = console.readString(">: ").charAt(0);;
				Machine.readSign(sign);
			} catch (SignNotInGrammatic | EndStateReachedException e) {
				System.err.println(e.getMessage());
				System.out.println(">: ");
			}
		}
	}
}
