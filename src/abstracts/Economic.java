package abstracts;

import java.util.ArrayList;

public abstract class Economic extends Element {
	private double funds;
	private ArrayList<AstralObject> estates;
	public double getFunds() {
		return this.funds;
	}
	public String toString() {
		return super.getName()+" has "+this.funds+" $";
	}
}
