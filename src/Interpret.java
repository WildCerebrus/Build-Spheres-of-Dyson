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
		} else if(code.equals("mod")){
			this.doMod();
		} else {
			throw new CommandException("instruction inexistante");
		}
	}
	private void doMod() throws IOException, CommandException {
		System.out.print("\rQue souhaitez-vous modifier (c/j/s/a) ? ");
		String s = this.in.readLine();
		int cas=0;
		switch(s){
			case "c" : {
				System.out.print("\rQuelle corporation voulez-vous modifier ? ");
				cas+=1;
			} break;
			case "j" : {
				System.out.print("\rQuel joueur voulez-vous modifier ? ");
				cas+=2;
			} break;
			case "s" : {
				System.out.print("\rQuel satellite voulez-vous modifier ? ");
				cas+=3;
			} break;
			case "a" : {
				System.out.print("\rQuel astre voulez-vous modifier ? ");
				cas+=4;
			} break;
			default : throw new CommandException("entrée non-conforme");
		}
		Corporation corporation=null;
		Player player=null;
		Satellite satellite=null;
		Star star=null;
		s = this.in.readLine();
		switch(cas){
			case 1 : {
				corporation=this.save.seekCorporation(s); 
				if(corporation==null) cas = -2;
			} break;
			case 2 : {
				player=this.save.seekPlayer(s); 
				if(player==null) cas = -2;
			} break;
			case 3 : {
				satellite=this.save.seekSatellite(s); 
				if(satellite==null) cas = -2;
			} break;
			case 4 : {
				star=this.save.seekStar(s); 
				if(star==null) cas = -2;
			} break;
		}
		if(cas==-2) throw new CommandException(s+" est introuvable");
		System.out.print("\rQue souhaitez-vous modifier à ");
		switch(cas){
			case 1 : System.out.print(corporation+" (p/n/f) ?"); break;
			case 2 : System.out.print(player+" (s/p/fu/fe) ?"); break;
			case 3 : System.out.print(satellite+" (p/sp/m/e/st/id/su) ?"); break;
			case 4 : System.out.print(star+" (p/n/m) ?"); break;
		}
		s=this.in.readLine()+cas;
		switch(s){
			case "p1" : {
				System.out.print("Comment voulez-vous modifier les joueurs de "+corporation.getName()+" ? "); 
				cas = 11; //TODO need suite
			} break;
			case "n1" : {
				System.out.print("Quel nom voulez-vous donner à la corporation ? ");
				cas = 12;
			} break; //TODO need suite
			case "f1" : {
				System.out.print("Comment voulez-vous modifier les fonds de "+corporation.getName()+" ? ");
				cas = 13;
			} break; //TODO need suite
			case "s2" : {
				System.out.print("Comment voulez-vous modifier les satellites de "+player.getPseudo()+" ? ");
				cas = 21;
			} break; //TODO need suite
			case "p2" : {
				System.out.print("Quel pseudo voulez-vous donner au joueur ? ");
				cas = 22;
			} break; //TODO need suite
			case "fu2" : {
				System.out.print("Comment voulez-vous modifier les fonds de "+player.getPseudo()+" ? ");
				cas = 23;
			} break; //TODO need suite
			case "fe2" : {
				System.out.print("Comment voulez-vous modifier la taxe d'adhésion de "+player.getPseudo()+" ? ");
				cas = 24;
			} break; //TODO need suite
			case "p3" : {
				System.out.print("Comment voulez-vous modifier la position du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 31;
			} break; //TODO need suite
			case "sp3" : {
				System.out.print("Comment voulez-vous modifier la vitesse du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 32;
			} break; //TODO need suite
			case "m3" : {
				System.out.print("Comment voulez-vous modifier la masse du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 33;
			} break; //TODO need suite
			case "e3" : {
				System.out.print("Comment voulez-vous modifier l'énergie du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 34;
			} break; //TODO need suite
			case "st3" : {
				System.out.print("Comment voulez-vous modifier l'état du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 35;
			} break; //TODO need suite
			case "id3" : {
				System.out.print("Quel identifiant voulez-vous donnez au satellite ? ");
				cas = 36;
			} break; //TODO need suite
			case "su3" : {
				System.out.print("Comment voulez-vous modifier l'astre du "+satellite.getType()+" "+satellite.getId()+" ? ");
				cas = 37;
			} break; //TODO need suite
			case "p4" : {
				System.out.print("Comment voulez-vous modifier la position de "+star.getName()+" ? ");
				cas = 41;
			} break; //TODO need suite
			case "n4" : {
				System.out.print("Quel nom voulez-vous donnez à l'astre ? ");
				cas = 42;
			} break; //TODO need suite
			case "m4" : {
				System.out.print("Comment voulez-vous modifier la masse de "+star.getName()+" ? ");
				cas = 43;
			} break; //TODO need suite
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
