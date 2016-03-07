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
	public void setMass(double m) {
		this.mass=m;
	}
	public void setEnergy(double e) {
		this.energy=e;
	}
	public void setEffectiveRadius(double e) {
		this.effectiveRadius=e;
	}
	public void setOwner(Economic o) {
		this.owner=o;
	}
	public void setPosition(Coordinates p) {
		this.position.setX(p.getX());
		this.position.setY(p.getY());
		this.position.setZ(p.getZ());
	}
	public void setSpeed(Coordinates s) {
		this.speed.setX(s.getX());
		this.speed.setY(s.getY());
		this.speed.setZ(s.getZ());
	}
	public void setAcceleration(Coordinates a) {
		this.acceleration.setX(a.getX());
		this.acceleration.setY(a.getY());
		this.acceleration.setZ(a.getZ());
	}
	public String toString() {
		return super.toString()+" is on "+this.position.toString();
	}
}
