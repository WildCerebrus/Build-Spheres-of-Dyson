import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Classe de Corporation (Alliance, Groupe de Players)
public class Corporation {
	private ArrayList<Player> players=new ArrayList<Player>(); //Liste des joueurs appartenant à la corporation
	private String name=""; //nom de la corporation
	private int pooledFunds=0; //fonds monétaires de la corporation
	//de base les champs sont initialisés comme ci-dessus
	public Corporation() {
	}
	//on peut initialiser avec le nom seulement
	public Corporation(String name){
		this.name=name;
	}
	//ou avec tous les champs
	public Corporation(ArrayList<Player> players,String name,int pooledFunds){
		if(players != null){ //on vérifie qu'il ait bien des membres à mettre
			addPlayer(players);
		}
		this.name=name;
		this.pooledFunds=pooledFunds;
	}
	//méthode d'ajout de joueurs à la corporation
	public void addPlayer(ArrayList<Player> players){
		int i;
		for(i=0;i<players.size();i++) this.players.add(players.get(i));
	}
	//méthode d'ajout d'un joueur à la corporation
	public void addPlayer(Player player){
		this.players.add(player);
	}
	public ArrayList<Player> getPlayers() {		//getters et setters
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPooledFunds() {
		return pooledFunds;
	}
	public void setPooledFunds(int pooledFunds) {
		this.pooledFunds = pooledFunds;
	}
	//trois affichages
	@Override
	public String toString(){
		return name+" a "+players.size()+" membres et "+pooledFunds+" $";
	}
	public String liste(){
		String liste=name+" a pour membres";
		int i;
		for(i=0;i<players.size();i++) liste+="\r\t"+players.get(i).getPseudo();
		return liste;
	}
	public void displayName(int n) {
		int i;
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print(this.name+"\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Joueurs :\r");
		for(i=0;i<this.players.size();i++){
			this.players.get(i).displayName(n+1);
		}
	}
	//mise à jour des données 
	public void update(int n) {
		int i,j;
		for(i=0;i<this.players.size();i++){
			j=this.players.get(i).getFees();
			this.players.get(i).setFunds(this.players.get(i).getFunds()-n*j);
			this.pooledFunds+=j*n;
		}
	}
	//recherche d'un joueur
	public Player seekPlayer(String s) {
		int i;
		for(i=0;i<this.players.size();i++){
			if(this.players.get(i).getPseudo().equals(s)) return this.players.get(i);
		}
		return null;
	}
	//modificateur
	public int doMod() throws Exception {
		String s="";
		System.out.println("Que voulez-vous modifier au "+name+" (j/n/p) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "j" : return doModPlayer();
			case "n" : return doModName();
			case "p" : return doModFunds();
			default : throw new CommandException("entrée incohérente");
		}
	}
	//modificateur de fonds communs
	private int doModFunds() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) les fonds ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quels fonds voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				this.setPooledFunds(this.getPooledFunds()+Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				this.setPooledFunds(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	//modificateur de nom
	private int doModName() throws IOException {
		System.out.println("Quel nom voulez-vos donnez à la corporation ? ");
		this.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());		
		return 0;
	}
	//modificateur de joueur
	private int doModPlayer() throws Exception {
		String s="";
		System.out.println("Quel joueur voulez-vous modifier (pseudo) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		Player p = seekPlayer(s);
		if(p!=null) return p.doMod();
		throw new Exception("Joueur non-trouvé");
	}
	//suppresseur
	public void end() throws Throwable {
		this.finalize();
	}
}
