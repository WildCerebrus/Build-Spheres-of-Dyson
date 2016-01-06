//Classe de dimensions (en mètre) d'un satellite
public class Dimensions {
	private double x,y,z; //dimensions 3D en mètre
	//déclaration à l'origine par défaut
	public Dimensions() { 
		this(0,0,0);
	}
	public Dimensions(double x, double y, double z) { //déclaration de type double
		this.setX(x);
		this.setY(y);
		this.setZ(z);
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
