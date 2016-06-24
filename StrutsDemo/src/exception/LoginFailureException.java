package exception;

public class LoginFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginFailureException(String msg){
		super(msg);
	}
	
}
