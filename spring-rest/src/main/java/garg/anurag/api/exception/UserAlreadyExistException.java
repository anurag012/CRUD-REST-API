package garg.anurag.api.exception;

public class UserAlreadyExistException extends RuntimeException {
	

	private static final long serialVersionUID = -6808645285927086103L;
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
	
	public UserAlreadyExistException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message, cause);
	}

}
