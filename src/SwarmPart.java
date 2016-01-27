import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Satellite de type partie d'essaim (panneau simple)
public class SwarmPart extends Satellite {
	private PanelDimensions panelDimensions;
	private String modele;
	//on peut initialiser un satellite par défaut
	public SwarmPart() {
		this(new Coordinates(),new Coordinates(),new Coordinates(),0,0,0,0,new Star(),new PanelDimensions(),
				"base");
	}
	//ou avec spécificités (conseillé)
	public SwarmPart(Coordinates position, Coordinates speed, Coordinates acceleration, double mass, 
			double energy, int state, int id, Star sun, PanelDimensions panelDimensions, String modele) {
		this.setPosition(position);
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setMass(mass);
		this.setEnergy(energy);
		this.setState(state);
		this.setId(id);
		this.setSun(sun);
		this.setType("SwarmPart");
		this.setDimensions(panelDimensions);
		this.setModele(modele);
	}
	private void setModele(String modele) {
		this.modele=modele;
	}
	public SwarmPart(int size) {
		this(new Coordinates(),new Coordinates(),new Coordinates(),0,0,0,size,new Star(),new PanelDimensions(),
				"base");
		}
	//transport du satellite
	public void teleportation(double dx, double dy, double dz) {
		this.getPosition().translate(dx, dy, dz);
	}
	//modification de la trajectoire
	public void redirection(double dx, double dy, double dz) {
		this.getSpeed().translate(dx, dy, dz);
	}
	//mise à jour du satellite après time secondes
	public void update(int time) {
		double radius = Math.sqrt(Math.pow(this.getPosition().getX(),2)+
				Math.pow(this.getPosition().getY(),2)+Math.pow(this.getPosition().getZ(),2));
		this.getAcceleration().setX(((this.getPosition().getX()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.getAcceleration().setY(((this.getPosition().getY()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.getAcceleration().setZ(((this.getPosition().getZ()*-1)/radius)*
				6.67384*this.getSun().getMass()/Math.pow(radius,2));
		this.redirection(this.getAcceleration().getX()*time, this.getAcceleration().getY()*time, 
				this.getAcceleration().getZ()*time);
		this.teleportation(this.getSpeed().getX()*time, this.getSpeed().getY()*time, 
				this.getSpeed().getZ()*time);
	}
	@Override
	public String toString() {
		return "\r\t"+this.getId()+" is at\r\tX : "+this.getPosition().getX()+"\r\tY : "+
				this.getPosition().getY()+"\r\tZ : "+this.getPosition().getZ()+"\r\tfrom "+
				this.getSun().getName();
	}
	public PanelDimensions getDimensions() {
		return this.panelDimensions;
	}
	public void setDimensions(PanelDimensions panelDimensions) {
		this.panelDimensions=panelDimensions;
	}
	@Override
	public String getModele() {
		return this.modele;
	}
	@Override
	public int doMod() throws Exception {
		String s="";
		System.out.println("Que voulez-vous modifier au "+this.getModele()+this.getId()+" (po/sp/ma/en/et/id/a/d/mo) ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		switch(s){
			case "po" : return this.getPosition().doMod();
			case "sp" : return this.getSpeed().doMod();
			case "ma" : return doModMass();
			case "en" : return doModEnergy();
			case "et" : return doModState();
			case "id" : return doModId();
			case "a" : return this.getSun().doMod();
			case "d" : return this.panelDimensions.doMod();
			case "mo" : return doModModele();
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModModele() throws IOException {
		System.out.println("Quel modèle voulez-vos donnez au satellite ? ");
		this.setModele(new BufferedReader(new InputStreamReader(System.in)).readLine());		
		return 0;
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
	private int doModEnergy() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) l'énergie ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quelle énergie voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				this.setEnergy(this.getEnergy()+Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				this.setEnergy(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModState() throws IOException, CommandException {
		String s="";
		System.out.println("Voulez-vous ajouter (a) ou régler (s) l'état ? ");
		s=new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Quel état voulez-vous entrer ? ");
		switch(s){
			case "a" : {
				this.setState(this.getState()+Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			case "s" : {
				this.setState(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
				return 0;
			}
			default : throw new CommandException("entrée incohérente");
		}
	}
	private int doModId() throws IOException {
		System.out.println("Quel nom voulez-vos donnez à l'astre ? ");
		this.setId(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));		
		return 0;
	}
}
