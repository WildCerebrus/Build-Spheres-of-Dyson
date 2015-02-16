
public class Coordonnees {
	private double x,y,z;
	public Coordonnees() {
		this.x=this.y=this.z=0;
	}
	public Coordonnees(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void add(Coordonnees coordonnees, double coefficient) {
		this.x+=coefficient*coordonnees.getx();
		this.y+=coefficient*coordonnees.gety();
		this.z+=coefficient*coordonnees.getz();
	}
	public void become(Coordonnees coordonnees) {
		this.x=coordonnees.getx();
		this.y=coordonnees.gety();
		this.z=coordonnees.getz();
	}
	public double getx() {
		return this.x;
	}
	public double gety() {
		return this.y;
	}
	public double getz() {
		return this.z;
	}
	public void setx(double x) {
		this.x=x;
	}
	public void sety(double y) {
		this.y=y;
	}
	public void setz(double z) {
		this.z=z;
	}
	public String toString() {
		return "\n\tX : " + this.x + " \tY : " + this.y + " \tZ : " + this.z;
	}
}
