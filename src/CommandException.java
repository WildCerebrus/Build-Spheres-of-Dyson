//Exception personalis�e

@SuppressWarnings("serial")
public class CommandException extends Exception {
	public CommandException(String message){
		super(message);
	}
}
