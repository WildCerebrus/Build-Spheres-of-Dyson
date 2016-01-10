//Classe générique abstraite de satellite
public abstract class Satellite {
	private Coordinates position, speed, acceleration; //coordonnées du satellite (lecture dépendant du type)
	private double mass, energy; //masse en kg et énergie stockée en kWh
	private int state, id; //état du satellite et identifiant
	private Star sun; //étoile autour de laquelle gravite le satellite
	private String type; //type du satellite (partie d'un essaim, ...
	public Coordinates getPosition() {		//getters et setters
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void displayName(int n) {
		int i;
		String s="le satellite n°"+this.id+" est un "+this.getType()+" de modèle "+this.getModele()+" et est en "+
					this.position.getX()+"\t"+this.position.getY()+"\t"+this.position.getZ();
		for(i=0;i<n;i++){
			System.out.print("\t");
		}
		System.out.print(s);
	}
	public abstract String getModele();
	public abstract void update(int n);
}
