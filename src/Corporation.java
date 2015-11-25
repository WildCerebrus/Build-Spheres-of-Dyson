import java.util.ArrayList;

public class Corporation {
	private ArrayList<Player> players;
	private String name;
	private int pooledFunds;
	public Corporation(){
		this.players=new ArrayList<Player>();
		this.name="";
		this.pooledFunds=0;
	}
	public Corporation(String name){
		this.players=new ArrayList<Player>();
		this.name=name;
		this.pooledFunds=0;
	}
	public Corporation(ArrayList<Player> players,String name,int pooledFunds){
		this.players=new ArrayList<Player>();
		if(players!=null){
			addPlayer(players);
		}
		this.name=name;
		this.pooledFunds=pooledFunds;
	}
	public void addPlayer(ArrayList<Player> players){
		int i;
		for(i=0;i<players.size();i++) this.players.add(players.get(i));
	}
	public void addPlayer(Player player){
		this.players.add(player);
	}
	public ArrayList<Player> getPlayers() {
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
