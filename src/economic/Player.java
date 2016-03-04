package economic;

import java.util.ArrayList;

import abstracts.AstralObject;
import abstracts.Economic;

public class Player extends Economic {
	public Player() {
		this.setFunds(0);
		this.setEstates(new ArrayList<AstralObject>());
		this.setCorporation(null);
		this.setName("");
	}
	public Player(Player p) {
		this.setFunds(p.getFunds());
		this.setEstates(p.getEstates());
		this.setCorporation(p.getCorporation());
		this.setName(p.getName());
	}
	public String toString() {
		return super.toString();
	}
}
