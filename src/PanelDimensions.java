//Classe de dimensions (en mètre) d'un satellite
public class PanelDimensions {
	private double length,width,thickness; //dimensions 3D en mètre
	//déclaration à l'origine par défaut
	public PanelDimensions() { 
		this(0,0,0);
	}
	public PanelDimensions(double length, double width, double thickness) { //déclaration de type double
		this.setLength(length);
		this.setWidth(width);
		this.setThickness(thickness);
	}
	@Override
	public String toString() {
		return "\r\tX = "+length+"\r\tY = "+width+"\r\tZ = "+thickness;
	}
	public double getLength() {			//getters et setters
		return this.length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
}
