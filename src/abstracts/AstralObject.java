package abstracts;

import data.Coordinates;

public abstract class AstralObject extends Element {
	private double mass;
	private double energy;
	private double effectiveRadius;
	private Economic owner;
	private Coordinates position;
	private Coordinates speed;
	private Coordinates acceleration;
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
	public Coordinates getPosition() {
		return this.position;
	}
	public Coordinates getSpeed() {
		return this.speed;
	}
	public Coordinates getAcceleration() {
		return this.acceleration;
	}
	public String toString() {
		return super.toString();
	}
}
