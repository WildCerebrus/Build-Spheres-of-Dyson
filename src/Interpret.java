import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Classe de lecture et d'interprétation des commandes
public class Interpret {
	private boolean exit; //booléen terminal
	private Save save; //sauvegarde associée
	private BufferedReader in; //lecteur de commandes
	//constructeur par défaut
	public Interpret(){
		this.exit=false;
		this.save=new Save();
		this.in=new BufferedReader(new InputStreamReader(System.in));
	}
	//interprète de commande
	public void decode_execute(String code) throws Throwable{
		//TODO load et save
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
		} else if(code.equals("ajt")){
			this.save.doAdd();
		} else if(code.equals("mod")){
			this.doMod();
		} else if(code.equals("spr")){
			this.doSpr();
		} else {
			throw new CommandException("instruction inexistante");
		}
	}
	//lanceur de suppression
	private int doSpr() throws Throwable {
		String s = "";
		System.out.println("Que souhaitez-vous supprimer (c/p/s/a) ? ");
		s=this.in.readLine();
		switch(s){
			case "c" : return doSprCorp();
			case "p" : return doSprPlayer();
			case "s" : return doSprSat();
			case "a" : return doSprStar();
			default : throw new CommandException("entrée incohérente");
		}
	}
	//suppresseur d'astre
	private int doSprStar() throws Throwable {
		String s = "";
		System.out.println("Quel astre voulez-vous supprimer (nom) ? ");
		s=this.in.readLine();
		if(this.save.seekStar(s)==null) throw new Exception("Corporation innexistante");
		this.save.seekStar(s).end();
		return 0;
	}
	//suppresseur de satellites
	private int doSprSat() throws Throwable {
		String s = "";
		System.out.println("Quelle satellite voulez-vous supprimer (nom) ? ");
		s=this.in.readLine();
		if(this.save.seekSatellite(s)==null) throw new Exception("Corporation innexistante");
		this.save.seekSatellite(s).end();
		return 0;
	}
	//suppresseur de joueur
	private int doSprPlayer() throws Throwable {
		String s = "";
		System.out.println("Quel joueur voulez-vous supprimer (nom) ? ");
		s=this.in.readLine();
		if(this.save.seekPlayer(s)==null) throw new Exception("Corporation innexistante");
		this.save.seekPlayer(s).end();
		return 0;
	}
	//suppresseur de corporation
	private int doSprCorp() throws Throwable {
		String s = "";
		System.out.println("Quelle corporation voulez-vous supprimer (nom) ? ");
		s=this.in.readLine();
		if(this.save.seekCorporation(s)==null) throw new Exception("Corporation innexistante");
		this.save.seekCorporation(s).end();
		return 0;
	}
	//lanceur de modification
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
	//modificateur d'astre
	private int doModStar() throws Exception {
		String s = "";
		System.out.println("Quel astre voulez-vous modifier (nom) ? ");
		s=this.in.readLine();
		return this.save.seekStar(s).doMod();
	}
	//modificateur de satellite
	private int doModSat() throws Exception {
		String s = "";
		System.out.println("Quel satellite voulez-vous modifier (id) ? ");
		s=this.in.readLine();
		return this.save.seekSatellite(s).doMod();
	}
	//modificateur de joueur
	private int doModPlayer() throws Exception {
		String s = "";
		System.out.println("Quel joueur voulez-vous modifier (pseudo) ? ");
		s=this.in.readLine();
		return this.save.seekPlayer(s).doMod();
	}
	//modificateur de corporation
	private int doModCorp() throws Exception {
		String s = "";
		System.out.println("Quelle corporation voulez-vous modifier (nom) ? ");
		s=this.in.readLine();
		return this.save.seekCorporation(s).doMod();
	}
	//mis à jour
	private void doUpdate() throws NumberFormatException, IOException {
		System.out.print("\rDe combien de secondes voulez-vous avancer ?");
		this.save.update(Integer.parseInt(this.in.readLine()));
	}
	//afficheur de sauvegarde
	private void doShowSave() {
		this.save.displayName(0);
	}
	//créateur d'astre
	private void doNewStar() throws IOException {
		System.out.print("\rNom de l'astre : ");
		this.save.addStar(new Star(this.in.readLine()));
	}
	//créateur de satellite
	private void doNewSatellite() throws IOException {
		System.out.print("\rType du Satellite (SwarmPart) : ");
		String s = new String(this.in.readLine());
		if(s.equals("SwarmPart")) this.save.addSatellite(new SwarmPart());
	}
	//créateur de joueur
	private void doNewPlayer() throws IOException {
		System.out.print("\rNom du Joueur : ");
		this.save.addPlayer(new Player(new String(this.in.readLine())));
	}
	//créateur de corporation
	private void doNewCorporation() throws IOException {
		System.out.print("\rNom de la Corporation :");
		this.save.addCorporation(new Corporation(new String(this.in.readLine())));
	}
	//termine l'exécution du programme
	private void doExit(){
		this.exit=true;
	}
	//affiche la liste des commandes
	public void doMenu(){
		System.out.println("menu : affiche le menu");
		System.out.println("nc : crée une nouvelle corporation");
		System.out.println("nj : crée un nouveau joueur");
		System.out.println("ns : crée un nouveau satellite");
		System.out.println("na : crée un nouvel astre");
		System.out.println("ms : montre la sauvegarde");
		System.out.println("up : avance dans le temps");
		System.out.println("ajt : permet l'ajout d'un élément");
		System.out.println("mod : permet la modification d'une donnée");
		System.out.println("spr : permet la suppression d'un élément");
		System.out.println("exit : ferme le programme");
	}
	//renvoie la valeur du booléen terminal
	public boolean exit(){
		return this.exit;
	}
	//lit les entrées clavier
	public String fetch() throws IOException {
		return this.in.readLine();
	}
	//affiche un caractère pour signaler l'attente d'instruction
	public void printPrompt(){
		System.out.println(">");
	}
}
