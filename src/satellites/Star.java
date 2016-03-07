package satellites;

import abstracts.AstralObject;
import data.Coordinates;

public class Star extends AstralObject {
	public Star() {
		this.setName("Star");
		this.setMass(Math.random()*Math.pow(10, 30));
		this.setEnergy(Math.random()*Math.pow(10, 26));
		this.setOwner(null);
		this.setCenter(null);
		this.setPosition(new Coordinates());
		this.setSpeed(new Coordinates());
		this.setAcceleration(new Coordinates());
	}
	public Star(Star s) {
		this.setName(s.getName());
		this.setMass(s.getMass());
		this.setEnergy(s.getEnergy());
		this.setEffectiveRadius(s.getEffectiveRadius());
		this.setOwner(s.getOwner());
		this.setCenter(s.getCenter());
		this.setPosition(new Coordinates(s.getPosition()));
		this.setSpeed(new Coordinates(s.getSpeed()));
		this.setAcceleration(new Coordinates(s.getAcceleration()));
	}
}
