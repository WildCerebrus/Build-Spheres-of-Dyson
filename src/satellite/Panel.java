package satellite;

import abstracts.Satellite;
import data.Coordinates;

public class Panel extends Satellite {
	public Panel() {
		this.setName("Panel"+Math.rint(Math.pow(10, 12)*Math.random()));
		this.setMass(Math.pow(10, 6)*Math.random());
		this.setEnergy(0);
		this.setEffectiveRadius(Math.pow(10, 3)*Math.random());
		this.setOwner(null);
		this.setPosition(new Coordinates());
		this.setSpeed(new Coordinates());
		this.setAcceleration(new Coordinates());
		this.setHealth(100);
	}
	public Panel(Panel p) {
		this.setName(p.getName());
		this.setMass(p.getMass());
		this.setEnergy(p.getEnergy());
		this.setEffectiveRadius(p.getEffectiveRadius());
		this.setOwner(p.getOwner());
		this.setPosition(new Coordinates(p.getPosition()));
		this.setSpeed(new Coordinates(p.getSpeed()));
		this.setAcceleration(new Coordinates(p.getAcceleration()));
		this.setHealth(p.getHealth());
	}
}
