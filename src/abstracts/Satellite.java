package abstracts;

public abstract class Satellite extends AstralObject {
	private int health;
	public void collect(double e) {
		this.addEnergy(e);
	}
	public void transmit(double e, AstralObject aim) {
		this.addEnergy(-e);
		aim.addEnergy(e);
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int h) {
		this.health=h;
	}
	public String toString() {
		return "("+this.health+"%) "+super.toString();
	}
}
