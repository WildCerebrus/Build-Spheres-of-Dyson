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
	public ArrayList<AstralObject> getEstates() {
		return this.estates;
	}
	public Corporation getCorporation() {
		return this.corporation;
	}
	public String toString() {
		return super.toString()+" has "+this.funds+" $";
	}
}
