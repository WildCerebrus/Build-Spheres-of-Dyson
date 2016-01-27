import java.io.IOException;

public class BuildSpheresofDyson {

	public static void main(String[] args) throws Exception {
		Interpret interpret = new Interpret();
		interpret.doMenu();
		while(!interpret.exit()){
			try{
				interpret.printPrompt();
				interpret.decode_execute(interpret.fetch());
			} catch(IOException e){
				e.printStackTrace();
			} catch(NumberFormatException e){
				e.printStackTrace();
			} catch(CommandException e){
				e.printStackTrace();
			}
		}
	}
}
