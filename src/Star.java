//Classe de déclaration des étoiles autour desquelles ont construit les SoD
public class Star {
	private Coordinates position;
	private String name;
	private double masse;
	public Star() {
		this(new Coordinates(),"",1.989*(Math.pow(10, 19)));
	}
	public Star(Coordinates position,String name,double masse) {
		this.setPosition(position);
		this.setName(name);
		this.setMasse(masse);
	}
	public void translate(double dx, double dy, double dz) {
		this.position.translate(dx, dy, dz);
	}
	public String toString() {
		return "\r\t"+name+position.toString();
	}
	public Coordinates getPosition() {
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
	public double getMasse() {
		return masse;
	}
	public void setMasse(double masse) {
		this.masse = masse;
	}
}
