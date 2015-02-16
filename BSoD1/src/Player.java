
public class Player {
	private String name = new String();
	private int id;
	private LSatellite satellites = new LSatellite();
	private double asset = 0;
	public Player(String name,int id) {
		this.name=new String (name);
		this.id=id;
	}
	public Player(String name,int id, LSatellite satellites, double asset) {
		this.name=new String (name);
		this.id=id;
		this.asset=asset;
		for(int i=0;i<satellites.getn();i++) {
			this.satellites.add(satellites.getsat(i));
		}
	}
	public LSatellite getsats() {
		return this.satellites;
	}
	public String getname() {
		return this.name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public int getid() {
		return this.id;
	}
	public void setid(int id) {
		this.id=id;
	}
	public double getasset() {
		return this.asset;
	}
	public void setasset(double asset) {
		this.asset=asset;
	}
	public String toString() {
		return this.name + " possède " + this.satellites.getn() + 
				" satellites et " +	this.asset + " $";
	}
}
