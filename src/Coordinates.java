// Classe de position cartésienne 3D en mètre
public class Coordinates {
	private double x,y,z; //coordonnées 3D en mètre
	//déclaration à l'origine par défaut
	public Coordinates() { 
		this(0,0,0);
	}
	public Coordinates(double x, double y, double z) { //déclaration de type double
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
