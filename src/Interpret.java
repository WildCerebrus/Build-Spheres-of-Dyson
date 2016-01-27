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
	private int doMod() throws IOException, CommandException {
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
			default : throw new CommandException("entr�e non-conforme");
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
		System.out.print("\rQue souhaitez-vous modifier � ");
		switch(cas){
			case 1 : System.out.print(corporation+" (p/n/f) ?"); break;
			case 2 : System.out.print(player+" (s/p/fu/fe) ?"); break;
			case 3 : System.out.print(satellite+" (p/sp/m/e/st/id/su) ?"); break;
			case 4 : System.out.print(star+" (p/n/m) ?"); break;
		}
		s=this.in.readLine()+cas;
		switch(s){
			case "p1" : {
				System.out.print("Comment voulez-vous modifier les joueurs de "+corporation.getName()+" (s/m/t) ? "); 
				cas = 11;
			} break;
			case "n1" : {
				System.out.print("Quel nom voulez-vous donner � la corporation ? ");
				cas = 12;
			} break;
			case "f1" : {
				System.out.print("Comment voulez-vous modifier les fonds de "+corporation.getName()+" (a/s) ? ");
				cas = 13;
			} break;
			case "s2" : {
				System.out.print("Comment voulez-vous modifier les satellites de "+player.getPseudo()+" (s/m/t) ? ");
				cas = 21;
			} break;
			case "p2" : {
				System.out.print("Quel pseudo voulez-vous donner au joueur ? ");
				cas = 22;
			} break;
			case "fu2" : {
				System.out.print("Comment voulez-vous modifier les fonds de "+player.getPseudo()+" (a/s) ? ");
				cas = 23;
			} break;
			case "fe2" : {
				System.out.print("Comment voulez-vous modifier la taxe d'adh�sion de "+player.getPseudo()+" (a/s) ? ");
				cas = 24;
			} break;
			case "p3" : {
				System.out.print("Comment voulez-vous modifier la position du "+satellite.getType()+" "+satellite.getId()+" (x/y/z/a) ? ");
				cas = 31;
			} break;
			case "sp3" : {
				System.out.print("Comment voulez-vous modifier la vitesse du "+satellite.getType()+" "+satellite.getId()+" (a/s) ? ");
				cas = 32;
			} break;
			case "m3" : {
				System.out.print("Comment voulez-vous modifier la masse du "+satellite.getType()+" "+satellite.getId()+" (a/s) ? ");
				cas = 33;
			} break;
			case "e3" : {
				System.out.print("Comment voulez-vous modifier l'�nergie du "+satellite.getType()+" "+satellite.getId()+" (a/s) ? ");
				cas = 34;
			} break;
			case "st3" : {
				System.out.print("Comment voulez-vous modifier l'�tat du "+satellite.getType()+" "+satellite.getId()+" (a/s) ? ");
				cas = 35;
			} break;
			case "id3" : {
				System.out.print("Quel identifiant voulez-vous donnez au satellite ? ");
				cas = 36;
			} break;
			case "su3" : {
				System.out.print("Que voulez-vous modifier de l'astre du "+satellite.getType()+" "+satellite.getId()+" (p/n/m/a) ? ");
				cas = 37;
			} break;
			case "p4" : {
				System.out.print("Comment voulez-vous modifier la position de "+star.getName()+" (a/s) ? ");
				cas = 41;
			} break;
			case "n4" : {
				System.out.print("Quel nom voulez-vous donnez � l'astre ? ");
				cas = 42;
			} break;
			case "m4" : {
				System.out.print("Comment voulez-vous modifier la masse de "+star.getName()+" (a/s) ? ");
				cas = 43;
			} break;
			default : throw new CommandException("entr�e invalide");
		}
		s=this.in.readLine();
		switch(cas){
			case 11 : {
				switch(s){
					case "s" : {
						System.out.print("Quel joueur de "+corporation.getName()+" voulez-vous modifier ? ");
						cas = 111; //TODO need suite
					} break;
					case "m" : {
						System.out.print("Combien de joueurs de "+corporation.getName()+" voulez-vous modifier ? ");
						cas = 112; //TODO need suite
					} break;
					case "t" : {
						System.out.print("Comment voulez-vous modifier tous les joueurs de "+corporation.getName()+" ? ");
						cas = 113; //TODO need suite
					} break;
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 12 : {
				corporation.setName(s);
				return 0;
			}
			case 13 : {
				switch(s){
					case "a" : cas = 131; break; //TODO need suite
					case "s" : cas = 132; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 21 : {
				switch(s){
					case "s" : {
						System.out.print("Quel satellite de "+player.getPseudo()+" voulez-vous modifier ? ");
						cas = 211; //TODO need suite
					} break;
					case "m" : {
						System.out.print("Combien de satellites de "+player.getPseudo()+" voulez-vous modifier ? ");
						cas = 212; //TODO need suite
					} break;
					case "t" : {
						System.out.print("Comment voulez-vous modifier tous les satellites de "+player.getPseudo()+" ? ");
						cas = 213; //TODO need suite
					} break;
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 22 : {
				player.setPseudo(s);
				return 0;
			}
			case 23 : {
				switch(s){
					case "s" : cas = 231; break; //TODO need suite
					case "a" : cas = 232; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 24 : {
				switch(s){
					case "s" : cas = 241; break; //TODO need suite
					case "a" : cas = 242; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 31 : {
				switch(s){
					case "x" : {
						System.out.print("Comment souhaitez-vous modifier la coordonn�e x du satellite (a/s) ? ");
						cas = 311;
					} break; //TODO need suite
					case "y" : {
						System.out.print("Comment souhaitez-vous modifier la coordonn�e y du satellite (a/s) ? ");
						cas = 312;
					} break; //TODO need suite
					case "z" : {
						System.out.print("Comment souhaitez-vous modifier la coordonn�e z du satellite (a/s) ? ");
						cas = 313;
					} break; //TODO need suite
					case "a" : {
						System.out.print("Vous avez pris toutes. Quelle valeur voulez-vous donnez � x ? ");
						satellite.getPosition().setX(Double.parseDouble(in.readLine()));
						System.out.print("Et y ? ");
						satellite.getPosition().setY(Double.parseDouble(in.readLine()));
						System.out.print("Et z ? ");
						satellite.getPosition().setX(Double.parseDouble(in.readLine()));
						return 0;
					}
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 32 : {
				switch(s){
					case "s" : cas = 321; break; //TODO need suite
					case "a" : cas = 322; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 33 : {
				switch(s){
					case "s" : cas = 331; break; //TODO need suite
					case "a" : cas = 332; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 34 : {
				switch(s){
					case "s" : cas = 341; break; //TODO need suite
					case "a" : cas = 342; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 35 : {
				switch(s){
					case "s" : cas = 351; break; //TODO need suite
					case "a" : cas = 352; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			} break;
			case 36 : {
				satellite.setId(Integer.parseInt(s));
				return 0;
			}
			case 37 : {
				switch(s){
					case "p" : cas = 371; break; //TODO need suite
					case "n" : cas = 372; break; //TODO need suite
					case "m" : cas = 373; break; //TODO need suite
					case "a" : cas = 374; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			}
			case 41 : {
				switch(s){
					case "s" : cas = 411; break; //TODO need suite
					case "a" : cas = 412; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			}
			case 42 : {
				star.setName(s);
				return 0;
			}
			case 43 : {
				switch(s){
					case "s" : cas = 431; break; //TODO need suite
					case "a" : cas = 432; break; //TODO need suite
					default : throw new CommandException("entr�e incoh�rente");
				}
			}
		}
		return 0;
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
		System.out.println("nc : cr�e une nouvelle corporation");
		System.out.println("nj : cr�e un nouveau joueur");
		System.out.println("ns : cr�e un nouveau satellite");
		System.out.println("na : cr�e un nouvel astre");
		System.out.println("ms : montre la sauvegarde");
		System.out.println("up : avance dans le temps");
		System.out.println("mod : permet la modification d'une donn�e");
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
