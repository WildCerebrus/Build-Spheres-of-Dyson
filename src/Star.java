//Classe de déclaration des étoiles autour desquelles ont construit les SoD
public class Star {
	private Coordinates position=new Coordinates(); //position du centre gravitationnel de l'astre
	private String name="sun"; //nom de l'astre
	private double mass=1.989*(Math.pow(10, 19)); //masse de l'étoile
	//de base les champs sont initialisés comme ci-dessus
	public Star() {}
	//mais on peut l'initialiser à l'aide de toutes ses données
	public Star(Coordinates position,String name,double mass) {
		this.setPosition(position);
		this.setName(name);
		this.setMass(mass);
	}
	//déplace l'étoile
	public void translate(double dx, double dy, double dz) {
		this.position.translate(dx, dy, dz);
	}
	@Override
	public String toString() {
		return "\r\t"+name+position.toString();
	}
	public Coordinates getPosition() {		//getters et setters
		return this.position;
	}
	public void setPosition(Coordinates position) {
		this.position=position;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
}
