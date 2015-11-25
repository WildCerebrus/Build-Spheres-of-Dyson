
public class SwarmPart extends Satellite {
	public SwarmPart() {
		this(new Coordinates(),new Coordinates(),new Coordinates(),0,0,0,0,new Star());
	}
	public SwarmPart(Coordinates position, Coordinates speed, Coordinates acceleration, 
			double mass, double energy, int state, int id, Star sun) {
		this.setPosition(position);
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setMass(mass);
		this.setEnergy(energy);
		this.setState(state);
		this.setId(id);
		this.setSun(sun);
	}
	public void teleportation(double dx, double dy, double dz) {
		this.position.translate(dx, dy, dz);
	}
	public void redirection(double dx, double dy, double dz) {
		this.speed.translate(dx, dy, dz);
	}
	public void update(int time) {
		double radius = Math.sqrt(Math.pow(this.getPosition().getX(),2)+
				Math.pow(this.getPosition().getY(),2)+Math.pow(this.getPosition().getZ(),2));
		this.acceleration.setX(((this.position.getX()*-1)/radius)*
				6.67384*this.getSun().getMasse()/Math.pow(radius,2));
		this.acceleration.setY(((this.position.getY()*-1)/radius)*
				6.67384*this.getSun().getMasse()/Math.pow(radius,2));
		this.acceleration.setZ(((this.position.getZ()*-1)/radius)*
				6.67384*this.getSun().getMasse()/Math.pow(radius,2));
		this.redirection(this.acceleration.getX()*time, this.acceleration.getY()*time, 
				this.acceleration.getZ()*time);
		this.teleportation(this.speed.getX()*time, this.speed.getY()*time, 
				this.speed.getZ()*time);
	}
	public String toString() {
		return "\r\t"+this.id+" is at\r\tX : "+this.position.getX()+"\r\tY : "+
				this.position.getY()+"\r\tZ : "+this.position.getZ()+"\r\tfrom "+
				this.sun.getName();
	}
}
