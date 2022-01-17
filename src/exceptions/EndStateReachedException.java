
package exceptions;

public class EndStateReachedException extends Exception{
	public EndStateReachedException() { super(); }
	public EndStateReachedException(String message) { super(message); }
	public EndStateReachedException(String message, Throwable t) { super(message, t); }
}
