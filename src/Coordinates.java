// Classe de position cart�sienne 3D en m�tre
public class Coordinates {
	private double x,y,z; //coordonn�es 3D en m�tre
	//d�claration � l'origine par d�faut
	public Coordinates() { 
		this(random(),random(),random());
	}
	private static double random() {
		return 2*Math.pow(10, 11)*(Math.random()-0.5);
	}
	public Coordinates(double x, double y, double z) { //d�claration de type double
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	//permet de translater un point
	public void translate(double dx, double dy, double dz) { 
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
		this.setZ(this.getZ() + dz);
	}
	@Override
	public String toString() {
		return "\r\tX = "+x+"\r\tY = "+y+"\r\tZ = "+z;
	}
	public double getX() {			//getters et setters
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
}
