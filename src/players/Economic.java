package players;

import data.Element;

public abstract class Economic extends Element {
	private double funds;
	public double getFunds() {
		return this.funds;
	}
	public String toString() {
		return super.getName()+" has "+this.funds+" $";
	}
}
