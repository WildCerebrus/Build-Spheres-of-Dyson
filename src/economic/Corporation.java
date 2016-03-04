package economic;

import java.util.ArrayList;

import abstracts.Economic;
import abstracts.AstralObject;

public class Corporation extends Economic {
	private ArrayList<Economic> members;
	public Corporation() {
		this.members=new ArrayList<Economic>();
		this.setFunds(0);
		this.setEstates(new ArrayList<AstralObject>());
		this.setCorporation(null);
		this.setName("");
	}
	public Corporation(Corporation c) {
		this.members=c.getMembers();
		this.setFunds(c.getFunds());
		this.setEstates(c.getEstates());
		this.setCorporation(c.getCorporation());
		this.setName(c.getName());
	}
	public ArrayList<Economic> getMembers() {
		return this.members;
	}
	public String toString() {
		return super.toString();
	}
}
