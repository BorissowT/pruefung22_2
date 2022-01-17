package exceptions;

public class SignNotInGrammatic extends Exception{
	public SignNotInGrammatic() { super(); }
	public SignNotInGrammatic(String message) { super(message); }
	public SignNotInGrammatic(String message, Throwable t) { super(message, t); }
}
