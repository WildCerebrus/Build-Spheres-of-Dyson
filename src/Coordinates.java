// Classe de d�claration des positions cart�siennes 3D en m�tre
public class Coordinates {
	private double x,y,z; //coordonn�es 3D en m�tre
	public Coordinates() {
		this(0,0,0);
	}
	public Coordinates(double x, double y, double z) {
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
	public String toString() {
		return "\r\tX = "+x+"\r\tY = "+y+"\r\tZ = "+z;
	}
	public double getX() {
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
