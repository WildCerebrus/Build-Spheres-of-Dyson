package abstracts;

import java.util.ArrayList;

import economic.Corporation;

public abstract class Economic extends Element {
	private double funds;
	private ArrayList<AstralObject> estates;
	private Corporation corporation;
	public double getFunds() {
		return this.funds;
	}
	public void setFunds(double f) {
		this.funds=f;
	}
	public ArrayList<AstralObject> getEstates() {
		return this.estates;
	}
	public void setEstates(ArrayList<AstralObject> e) {
		this.estates=new ArrayList<AstralObject>();
		this.estates.addAll(e);
	}
	public Corporation getCorporation() {
		return this.corporation;
	}
	public void setCorporation(Corporation c) {
		this.corporation=new Corporation(c);
	}
	public String toString() {
		return super.toString()+" has "+this.funds+" $";
	}
}
