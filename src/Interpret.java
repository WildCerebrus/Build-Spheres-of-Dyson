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
		} else if(code.equals("nc")){
			this.doNewCorporation();
		} else if(code.equals("nj")){
			this.doNewPlayer();
		} else if(code.equals("ns")){
			this.doNewSatellite();
		} else if(code.equals("na")){
			this.doNewStar();
		} else if(code.equals("ms")){
			this.doShowSave();
		} else if(code.equals("up")){
			this.doUpdate();
		} else {
			throw new CommandException("instruction inexistante");
		}
	}
	private void doUpdate() throws NumberFormatException, IOException {
		System.out.print("\rDe combien de secondes voulez-vous avancer ?");
		this.save.update(Integer.parseInt(this.in.readLine()));
	}
	private void doShowSave() {
		this.save.displayName(0);
	}
	private void doNewStar() throws IOException {
		System.out.print("\rNom de l'astre : ");
		this.save.addStar(new Star(this.in.readLine()));
	}
	private void doNewSatellite() throws IOException {
		System.out.print("\rType du Satellite (SwarmPart) : ");
		String s = new String(this.in.readLine());
		if(s.equals("SwarmPart")) this.save.addSatellite(new SwarmPart());
	}
	private void doNewPlayer() throws IOException {
		System.out.print("\rNom du Joueur : ");
		this.save.addPlayer(new Player(new String(this.in.readLine())));
	}
	private void doNewCorporation() throws IOException {
		System.out.print("\rNom de la Corporation :");
		this.save.addCorporation(new Corporation(new String(this.in.readLine())));
	}
	private void doExit(){
		this.exit=true;
	}
	public void doMenu(){
		System.out.println("menu : affiche le menu");
		System.out.println("nc : crée une nouvelle corporation");
		System.out.println("nj : crée un nouveau joueur");
		System.out.println("ns : crée un nouveau satellite");
		System.out.println("na : crée un nouvel astre");
		System.out.println("ms : montre la sauvegarde");
		System.out.println("up : avance dans le temps");
		System.out.println("exit : ferme le programme");
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
