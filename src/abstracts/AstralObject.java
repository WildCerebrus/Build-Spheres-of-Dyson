package abstracts;

public abstract class AstralObject extends Element {
	private double mass;
	private double energy;
	private double effectiveRadius;
	private Economic owner;
	public double getMass() {
		return this.mass;
	}
	public double getEnergy() {
		return this.energy;
	}
	public double getEffectiveRadius() {
		return this.effectiveRadius;
	}
	public Economic getOwner() {
		return this.owner;
	}
	public String toString() {
		return super.toString();
	}
}
