//Satellite de type partie d'essaim (panneau simple)
public class SwarmPart extends Satellite {
	private PanelDimensions panelDimensions;
	//on peut initialiser un satellite par défaut
	public SwarmPart() {
		this(new Coordinates(),new Coordinates(),new Coordinates(),0,0,0,0,new Star(),new PanelDimensions());
	}
	//ou avec spécifictés (conseillé)
	public SwarmPart(Coordinates position, Coordinates speed, Coordinates acceleration, 
			double mass, double energy, int state, int id, Star sun, PanelDimensions panelDimensions) {
		this.setPosition(position);
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setMass(mass);
		this.setEnergy(energy);
		this.setState(state);
		this.setId(id);
		this.setSun(sun);
		this.setType("SwarmPart");
		this.setDimensions(panelDimensions);
	}
	//transport du satellite
	public void teleportation(double dx, double dy, double dz) {
		this.getPosition().translate(dx, dy, dz);
	}
	//modification de la trajectoire
	public void redirection(double dx, double dy, double dz) {
		this.getSpeed().translate(dx, dy, dz);
	}
	//mise à jour du satellite après time secondes
	public void update(int time) {
		double radius = Math.sqrt(Math.pow(this.getPosition().getX(),2)+
				Math.pow(this.getPosition().getY(),2)+Math.pow(this.getPosition().getZ(),2));
		this.getAcceleration().setX(((this.getPosition().getX()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.getAcceleration().setY(((this.getPosition().getY()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.getAcceleration().setZ(((this.getPosition().getZ()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.redirection(this.getAcceleration().getX()*time, this.getAcceleration().getY()*time, 
				this.getAcceleration().getZ()*time);
		this.teleportation(this.getSpeed().getX()*time, this.getSpeed().getY()*time, 
				this.getSpeed().getZ()*time);
	}
	@Override
	public String toString() {
		return "\r\t"+this.getId()+" is at\r\tX : "+this.getPosition().getX()+"\r\tY : "+
				this.getPosition().getY()+"\r\tZ : "+this.getPosition().getZ()+"\r\tfrom "+
				this.getSun().getName();
	}
	public PanelDimensions getDimensions() {
		return this.panelDimensions;
	}
	public void setDimensions(PanelDimensions panelDimensions) {
		this.panelDimensions=panelDimensions;
	}
}
