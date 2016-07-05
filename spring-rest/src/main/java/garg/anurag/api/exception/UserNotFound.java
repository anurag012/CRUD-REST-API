package garg.anurag.api.exception;

public class UserNotFound extends RuntimeException{


	private static final long serialVersionUID = -6808645285927086103L;
	
	public UserNotFound(String message) {
		super(message);
	}
	
	public UserNotFound(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message, cause);
	}

}
