
public class Satellite {
	private Coordonnees position = new Coordonnees(), 
						speed = new Coordonnees(),
						acceleration = new Coordonnees();
	private int model, size, weight;
	private String name = new String();
	public Satellite(Coordonnees position, Coordonnees speed, String name) {
		this.position.setx(position.getx());
		this.position.sety(position.gety());
		this.position.setz(position.getz());
		this.speed.setx(speed.getx());
		this.speed.sety(speed.gety());
		this.speed.setz(speed.getz());
		this.name= new String(name);
		this.acceleration = new Coordonnees();
	}
	public String getname() {
		return this.name;
	}
	public void setname(String name) {
		this.name=new String(name);
	}
	public int getmodel() {
		return this.model;
	}
	public void setmodel(int modele) {
		this.model=modele;
	}
	public int getsize() {
		return this.size;
	}
	public void setsize(int size) {
		this.size=size;
	}
	public int getweight() {
		return this.weight;
	}
	public void setweight(int weight) {
		this.weight=weight;
	}
	public Coordonnees getposition() {
		return this.position;
	}
	public void setposition(Coordonnees position) {
		this.position.setx(position.getx());
		this.position.sety(position.gety());
		this.position.setz(position.getz());
	}
	public Coordonnees getspeed() {
		return this.speed;
	}
	public void setspeed(Coordonnees speed) {
		this.speed.setx(speed.getx());
		this.speed.sety(speed.gety());
		this.speed.setz(speed.getz());
	}
	public Coordonnees getacceleration() {
		return this.acceleration;
	}
	public void setacceleration(Coordonnees acceleration) {
		this.acceleration.setx(acceleration.getx());
		this.acceleration.sety(acceleration.gety());
		this.acceleration.setz(acceleration.getz());
	}
	public String toString() {
		return "\n" + this.name + "   \ttype " + this.model + "\n\t" + 
				this.size + " m     \t" + this.weight + " kg\n" + 
				"position : " + this.position + "\n" +
				"vitesse : " + this.speed + "\n" +
				"accélération : " + this.acceleration;
	}
	public void copy(Satellite sat) {
		this.acceleration.setx(sat.getacceleration().getx());
		this.acceleration.sety(sat.getacceleration().gety());
		this.acceleration.setz(sat.getacceleration().getz());
		this.model=sat.getmodel();
		this.name=sat.getname();
		this.position.setx(sat.getposition().getx());
		this.position.sety(sat.getposition().gety());
		this.position.setz(sat.getposition().getz());
		this.size=sat.getsize();
		this.speed.setx(sat.getspeed().getx());
		this.speed.sety(sat.getspeed().gety());
		this.speed.setz(sat.getspeed().getz());
		this.weight=sat.getweight();
	}
}
