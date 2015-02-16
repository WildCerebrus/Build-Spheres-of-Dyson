
public class LSatellite {
	private int n;
	private String name = new String();
	private Satellite[] list = new Satellite[100];
	public LSatellite() {
		this.n=0;
		this.name="";
	}
	public LSatellite(String name) {
		n=0;
		this.name=new String(name);
	}
	public void add(Satellite sat) {
		list[n] = new Satellite(sat.getposition(),sat.getspeed(),sat.getname());
		this.list[n].setacceleration(sat.getacceleration());
		this.list[n].setweight(sat.getweight());
		this.list[n].setmodel(sat.getmodel());
		this.list[n].setsize(sat.getsize());
		this.n++;
	}
	public String toString() {
		String s = "";
		s+=this.name + " :";
		for(int i=0;i<this.n;i++) {
			s+="\nSatellite " + (i+1) + this.list[i];
		}
		return s;
	}
	public int getn() {
		return this.n;
	}
	public Satellite getsat(int i) {
		return this.list[i];
	}
	public int satIn(Satellite sat) {
		for(int i=0;i<this.n;i++) {
			if(this.list[i].getname().equals(sat.getname())) 
				if(this.list[i].getposition().equals(sat.getposition())) 
					return i;
		}
		return -1;
	}
	public void destroy(Satellite sat) {
		int j = satIn(sat);
		if (j>=0) for(int i=j;i<n;i++) {
			this.list[i].copy(this.list[i+1]);
		}
		this.n--;
	}
}
