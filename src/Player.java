import java.util.ArrayList;

public class Player {
	private ArrayList<Satellite> satellites=new ArrayList<Satellite>();
	private String pseudo="";
	private int funds=0;
	public Player() {
	}
	public Player(String pseudo) {
		this.pseudo=pseudo;
	}
	public Player(ArrayList<Satellite> satellites, String pseudo, int funds) {
		if (satellites != null) {
			addSat(satellites);
		}
		this.pseudo=pseudo;
		this.funds=funds;
	}
	public void addSat(ArrayList<Satellite> satellites) {
		int i;
		for(i=0;i<satellites.size();i++) addSat(satellites.get(i));
	}
	public void addSat(Satellite satellite) {
		this.satellites.add(satellite);
	}
	public ArrayList<Satellite> getSatellites() {
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
	public String toString() {
		return pseudo + " have " + satellites.size() + " satellites & " + funds + " $";
	}
	public String listeSat() {
		String liste=this.pseudo+" possède ";
		int i;
		for(i=0;i<this.satellites.size();i++) liste+="\r\t"+satellites.get(i).getId();
		return liste;
	}
}
