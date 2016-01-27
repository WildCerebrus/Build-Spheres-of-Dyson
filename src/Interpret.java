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
	public void decode_execute(String code) throws Exception{
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
		} else if(code.equals("mod")){
			this.doMod();
		} else {
			throw new CommandException("instruction inexistante");
		}
	}
	private int doMod() throws Exception {
		String s = "";
		System.out.println("Que souhaitez-vous modifier (c/p/s/a) ? ");
		s=this.in.readLine();
		switch(s){
			case "c" : return doModCorp();
			case "p" : return doModPlayer();
			case "s" : return doModSat();
			case "a" : return doModStar();
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModStar() throws Exception {
		String s = "";
		System.out.println("Quel astre voulez-vous modifier (nom) ? ");
		s=this.in.readLine();
		return this.save.seekStar(s).doMod();
	}
	private int doModSat() throws Exception {
		String s = "";
		System.out.println("Quel satellite voulez-vous modifier (id) ? ");
		s=this.in.readLine();
		return this.save.seekSatellite(s).doMod();
	}
	private int doModPlayer() throws Exception {
		String s = "";
		System.out.println("Quel joueur voulez-vous modifier (pseudo) ? ");
		s=this.in.readLine();
		return this.save.seekPlayer(s).doMod();
	}
	private int doModCorp() throws Exception {
		String s = "";
		System.out.println("Quelle corporation voulez-vous modifier (nom) ? ");
		s=this.in.readLine();
		return this.save.seekCorporation(s).doMod();
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
		System.out.println("mod : permet la modification d'une donnée");
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
