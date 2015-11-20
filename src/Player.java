import java.util.ArrayList;

public class Player {
	private ArrayList<Satellite> satellites;
	private String pseudo;
	private int funds;
	public Player() {
		this.satellites=new ArrayList<Satellite>();
		this.pseudo="";
		this.funds=0;
	}
	public Player(String pseudo) {
		this.satellites=new ArrayList<Satellite>();
		this.pseudo=pseudo;
		this.funds=0;
	}
	public Player(ArrayList<Satellite> satellites, String pseudo, int funds) {
		this.satellites=new ArrayList<Satellite>();
		if (satellites!=null) {
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
}
