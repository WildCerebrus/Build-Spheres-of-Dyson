import java.io.BufferedReader;
import java.io.InputStreamReader;

//Classe de dimensions (en mètre) d'un satellite
public class PanelDimensions {
	private double length,width,thickness; //dimensions 3D en mètre
	//déclaration à 0 par défaut
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
	//modificateur
	public int doMod() throws Exception {
		String s="";
		System.out.println("Quelle coordonnée voulez-vous changer et comment (xa/xs/ya/...) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "xa" : {
				System.out.println("De combien voulez-vous modifier la longueur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setLength(this.getLength()+Double.parseDouble(s));
				return 0;
			}
			case "xs" : {
				System.out.println("Quelle valeur voulez-vous donner en longueur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setLength(Double.parseDouble(s));
				return 0;
			}
			case "ya" : {
				System.out.println("De combien voulez-vous modifier la largeur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setWidth(this.getWidth()+Double.parseDouble(s));
				return 0;
			}
			case "ys" : {
				System.out.println("Quelle valeur voulez-vous donner en largeur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setWidth(Double.parseDouble(s));
				return 0;
			}
			case "za" : {
				System.out.println("De combien voulez-vous modifier l'épaisseur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setThickness(this.getThickness()+Double.parseDouble(s));
				return 0;
			}
			case "zs" : {
				System.out.println("Quelle valeur voulez-vous donner en épaisseur ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setThickness(Double.parseDouble(s));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
}
