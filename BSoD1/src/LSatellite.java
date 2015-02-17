import java.lang.Math;

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
	public double distance(Satellite sat1, Satellite sat2) {
		return Math.sqrt((sat1.getposition().getx()-sat2.getposition().getx())*(sat1.getposition().getx()-sat2.getposition().getx())+
						 (sat1.getposition().gety()-sat2.getposition().gety())*(sat1.getposition().gety()-sat2.getposition().gety())+
						 (sat1.getposition().getz()-sat2.getposition().getz())*(sat1.getposition().getz()-sat2.getposition().getz()));
	}
	public double distance(Satellite sat) {
		return Math.sqrt(sat.getposition().getx()*sat.getposition().getx()+
						 sat.getposition().gety()*sat.getposition().gety()+
						 sat.getposition().getz()*sat.getposition().getz());
	}
	public void collision(Satellite sat1, Satellite sat2) {
		if((satIn(sat1)>=0)&&(satIn(sat2)>=0)) {
			double collision = (sat1.getsize() > sat2.getsize()) ? sat1.getsize() : sat2.getsize();
			if(distance(sat1,sat2)<collision) {
				destroy(sat1);
				destroy(sat2);
			}
		}
	}
	public void refresh(double weight,double second) {
		double a,d;
		Coordonnees temp = new Coordonnees();
		for(int i=0;i<this.n;i++) {
			d=distance(this.list[i]);
			a=1.777*(10^8)/(d*d);
			temp.setx(-this.list[i].getposition().getx()*a/d);
			temp.sety(-this.list[i].getposition().gety()*a/d);
			temp.setz(-this.list[i].getposition().getz()*a/d);
			this.list[i].setacceleration(temp);
			temp.setx(this.list[i].getspeed().getx()+second*this.list[i].getacceleration().getx());
			temp.sety(this.list[i].getspeed().gety()+second*this.list[i].getacceleration().gety());
			temp.setz(this.list[i].getspeed().getz()+second*this.list[i].getacceleration().getz());
			this.list[i].setspeed(temp);
			temp.setx(this.list[i].getposition().getx()+second*this.list[i].getspeed().getx());
			temp.sety(this.list[i].getposition().gety()+second*this.list[i].getspeed().gety());
			temp.setz(this.list[i].getposition().getz()+second*this.list[i].getspeed().getz());
			this.list[i].setposition(temp);
		}
	}
}
