
public abstract class Satellite {
	protected Coordinates position, speed, acceleration;
	protected double mass, energy;
	protected int state, id;
	protected Star sun;
	public Coordinates getPosition() {
		return position;
	}
	public Coordinates getSpeed() {
		return speed;
	}
	public void setSpeed(Coordinates speed) {
		this.speed = speed;
	}
	public Coordinates getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Coordinates acceleration) {
		this.acceleration = acceleration;
	}
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Star getSun() {
		return sun;
	}
	public void setSun(Star sun) {
		this.sun = sun;
	}
	
}
