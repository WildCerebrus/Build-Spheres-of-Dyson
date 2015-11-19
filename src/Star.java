//Classe de déclaration des étoiles autour desquelles ont construit les SoD
public class Star {
	private Coordinates position;
	private String name;
	public Star() {
		this(new Coordinates(),"");
	}
	public Star(Coordinates position,String name) {
		this.setPosition(position);
		this.setName(name);
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
}
