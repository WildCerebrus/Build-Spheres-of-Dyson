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
	}
	public Corporation(Corporation c) {
		this.members=c.getMembers();
		this.setFunds(c.getFunds());
		this.setEstates(c.getEstates());
		this.setCorporation(c.getCorporation());
	}
	public void addMember(Economic e) {
		this.members.add(e);
		e.getCorporation().members.remove(e);
		e.setCorporation(this);
	}
	public void deleteMember(Economic e) {
		this.members.remove(e);
		e.setCorporation(null);
	}
	public ArrayList<Economic> getMembers() {
		return this.members;
	}
	public String toString() {
		return super.toString();
	}
}
