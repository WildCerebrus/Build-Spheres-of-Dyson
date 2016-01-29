import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Classe de déclaration des étoiles autour desquelles ont construit les SoD
public class Star {
	private Coordinates position=new Coordinates(); //position du centre gravitationnel de l'astre
	private String name="sun"; //nom de l'astre
	private double mass=1.989*(Math.pow(10, 19)); //masse de l'étoile
	//de base les champs sont initialisés comme ci-dessus
	public Star() {}
	//mais on peut l'initialiser à l'aide de toutes ses données
	public Star(Coordinates position,String name,double mass) {
		this.setPosition(position);
		this.setName(name);
		this.setMass(mass);
	}
	//ou juste vec un nom
	public Star(String name) {
		this.name=name;
	}
	//déplace l'étoile
	public void translate(double dx, double dy, double dz) {
		this.position.translate(dx, dy, dz);
	}
	@Override
	public String toString() {
		return "\r\t"+name+position.toString();
	}
	public Coordinates getPosition() {		//getters et setters
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
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public void displayName(int n) {
		int i;
		String s = "l'astre "+this.name+" est en "+this.position.getX()+"\t"+this.position.getY()+"\t"
				+this.position.getZ();
		for(i=0;i<n;i++){
			System.out.print("\t");
		}
		System.out.print(s);
	}
	public void update(int n) {
		// TODO Auto-generated method stub
	}
	public int doMod() throws Exception {
		String s="";
		System.out.println("Que voulez-vous modifier à "+this.name+" (p/n/m) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "p" : return this.position.doMod();
			case "n" : return doModName();
			case "m" : return doModMass();
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModMass() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) la masse ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quelle masse voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				this.setMass(this.getMass()+Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				this.setMass(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModName() throws IOException {
		System.out.println("Quel nom voulez-vos donnez à l'astre ? ");
		this.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());		
		return 0;
	}
	public void end() throws Throwable {
		this.finalize();
	}
}
