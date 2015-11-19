import java.util.ArrayList;

public class Player {
	private ArrayList<Satellite> satellites;
	private int nbSat;
	private String pseudo;
	private int funds;
	public ArrayList<Satellite> getSatellites() {
		return satellites;
	}
	public void setSatellites(ArrayList<Satellite> satellites) {
		this.satellites = satellites;
	}
	public int getNbSat() {
		return nbSat;
	}
	public void setNbSat(int nbSat) {
		this.nbSat = nbSat;
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
}
