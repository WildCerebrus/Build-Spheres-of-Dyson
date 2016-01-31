import java.io.BufferedReader;
import java.io.InputStreamReader;

// Classe de position cartésienne 3D en mètre
public class Coordinates {
	private double x,y,z; //coordonnées 3D en mètre
	//déclaration aléatoire par défaut
	public Coordinates() { 
		this(random(),random(),random());
	}
	private static double random() {
		return Math.pow(10, 9)*(Math.random()-0.5); //génération aléatoire de coordonnées
	}
	public Coordinates(double x, double y, double z) { //déclaration valuée
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
	public int doMod() throws Exception { //modificateur
		String s="";
		System.out.println("Quelle coordonnée voulez-vous changer et comment (xa/xs/ya/...) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "xa" : { 
				System.out.println("De combien voulez-vous modifier x ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setX(this.getX()+Double.parseDouble(s));
				return 0;
			}
			case "xs" : {
				System.out.println("Quelle valeur voulez-vous donner à x ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setX(Double.parseDouble(s));
				return 0;
			}
			case "ya" : {
				System.out.println("De combien voulez-vous modifier y ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setY(this.getY()+Double.parseDouble(s));
				return 0;
			}
			case "ys" : {
				System.out.println("Quelle valeur voulez-vous donner à y ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setY(Double.parseDouble(s));
				return 0;
			}
			case "za" : {
				System.out.println("De combien voulez-vous modifier z ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setZ(this.getZ()+Double.parseDouble(s));
				return 0;
			}
			case "zs" : {
				System.out.println("Quelle valeur voulez-vous donner à z ? ");
				s=new BufferedReader(new InputStreamReader(System.in)).readLine();
				this.setZ(Double.parseDouble(s));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
}
