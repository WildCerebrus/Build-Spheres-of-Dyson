import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interpret {
	private boolean exit;
	private Save save;
	private BufferedReader in;
	public Interpret(){
		this.exit=false;
		this.save=new Save();
		this.in=new BufferedReader(new InputStreamReader(System.in));
	}
	public void decode_execute(String code) throws CommandException, NumberFormatException, IOException{
		if(code.equals("exit")){
			this.doExit();
		} else if(code.equals("menu")){
			this.doMenu();
		} else if(code.equals("new_corporation")){
			this.doNewCorporation();
		} else if(code.equals("new_player")){
			this.doNewPlayer();
		} else if(code.equals("new_satellite")){
			this.doNewSatellite();
		} else if(code.equals("new_star")){
			this.doNewStar();
		} else {
			throw new CommandException("instruction inexistante");
		}
	}
	private void doNewStar() throws IOException {
		System.out.println("\rStar's name : ");
		this.save.addStar(new Star(this.in.readLine()));
	}
	private void doNewSatellite() throws IOException {
		System.out.print("\rSatellite's type : ");
		String s = new String(this.in.readLine());
		if(s.equals("SwarmPart")) this.save.addSatellite(new SwarmPart());
	}
	private void doNewPlayer() throws IOException {
		System.out.print("\rPlayer's name : ");
		this.save.addPlayer(new Player(new String(this.in.readLine())));
	}
	private void doNewCorporation() throws IOException {
		System.out.print("\rCorporation's name :");
		this.save.addCorporation(new Corporation(new String(this.in.readLine())));
	}
	private void doExit(){
		this.exit=true;
	}
	public void doMenu(){
		System.out.println("menu");
		System.out.println("new_corporation");
		System.out.println("new_player");
		System.out.println("new_satellite");
		System.out.println("new_star");
		System.out.println("exit");
	}
	public boolean exit(){
		return this.exit;
	}
	public String fetch() throws IOException {
		return this.in.readLine();
	}
	public void printPrompt(){
		System.out.println(">");
	}
}
