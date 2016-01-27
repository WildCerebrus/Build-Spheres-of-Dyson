import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Classe de joueur
public class Player {
	private ArrayList<Satellite> satellites=new ArrayList<Satellite>(); //liste des satellites du joueurs
	private String pseudo=""; //pseudonyme du joueur
	private int funds=0; //fonds monétaires du joueur
	private int fees=0;
	//de base les champs sont initialisés comme ci-dessus
	public Player() {}
	//on peut initialiser avec le pseudo seulement
	public Player(String pseudo) {
		this.pseudo=pseudo;
	}
	//ou avec tous les champs
	public Player(ArrayList<Satellite> satellites, String pseudo, int funds, int fees) {
		if (satellites != null) {//on vérifie qu'il y a bien des satellites à mettre
			addSat(satellites);
		}
		this.pseudo=pseudo;
		this.funds=funds;
	}
	//méthode pour ajouter des satellites
	public void addSat(ArrayList<Satellite> satellites) {
		int i;
		for(i=0;i<satellites.size();i++) addSat(satellites.get(i));
	}
	//méthode pour ajouter un satellite
	public void addSat(Satellite satellite) {
		this.satellites.add(satellite);
	}
	public ArrayList<Satellite> getSatellites() {		//getters et setters
		return satellites;
	}
	public void setSatellites(ArrayList<Satellite> satellites) {
		this.satellites = satellites;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getFunds() {
		return funds;
	}
	public void setFunds(int funds) {
		this.funds = funds;
	}
	//deux affichages
	@Override
	public String toString() {
		return pseudo + " have " + satellites.size() + " satellites & " + funds + " $";
	}
	public String listeSat() {
		String liste=this.pseudo+" possède ";
		int i;
		for(i=0;i<this.satellites.size();i++) liste+="\r\t"+satellites.get(i).getId();
		return liste;
	}
	public void displayName(int n) {
		int i;
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print(this.pseudo+"\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Satellites :\r");
		for(i=0;i<this.satellites.size();i++){
			this.satellites.get(i).displayName(n+1);
		}
	}
	public int getFees() {
		return this.fees;
	}
	public void update(int n) {
		// TODO Auto-generated method stub
	}
	public int doMod() throws Exception {
		String s="";
		System.out.println("Que voulez-vous modifier au "+pseudo+" (s/p/f/c) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "s" : return doModSat();
			case "p" : return doModPseudo();
			case "f" : return doModFunds();
			case "c" : return doModFees();
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModFees() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) la taxe corporative ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quelle taxe voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				fees=(this.getFees()+Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				fees=(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModFunds() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) les fonds ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quels fonds voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				this.setFunds(this.getFunds()+Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				this.setFunds(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModPseudo() throws IOException {
		System.out.println("Quel pseudo voulez-vos donnez au joueur ? ");
		this.setPseudo(new BufferedReader(new InputStreamReader(System.in)).readLine());		
		return 0;
	}
	private int doModSat() throws Exception {
		String s="";
		System.out.println("Quel satellite voulez-vous modifier (id) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		Satellite sat = seekSat(Integer.parseInt(s));
		if(sat!=null) return sat.doMod();
		throw new Exception("Satellite non-trouvé");
	}
	private Satellite seekSat(int n) {
		int i;
		for(i=0;i<satellites.size();i++){
			if(satellites.get(i).getId()==n) return satellites.get(i);
		}
		return null;
	}
}
