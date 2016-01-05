import java.util.ArrayList;
//Classe de Corporation (Alliance, Groupe de Players)
public class Corporation {
	private ArrayList<Player> players=new ArrayList<Player>(); //Liste des joueurs appartenant � la corporation
	private String name=""; //nom de la corporation
	private int pooledFunds=0; //fonds mon�taires de la corporation
	//de base les champs sont initialis�s comme ci-dessus
	public Corporation(){}
	//on peut initialiser avec le nom seulement
	public Corporation(String name){
		this.name=name;
	}
	//ou avec tous les champs
	public Corporation(ArrayList<Player> players,String name,int pooledFunds){
		if(players != null){ //on v�rifie qu'il ait bien des membres � mettre
			addPlayer(players);
		}
		this.name=name;
		this.pooledFunds=pooledFunds;
	}
	//m�thode d'ajout de joueurs � la corporation
	public void addPlayer(ArrayList<Player> players){
		int i;
		for(i=0;i<players.size();i++) this.players.add(players.get(i));
	}
	//m�thode d'ajout d'un joueur � la corporation
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
	//deux affichages
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
}
