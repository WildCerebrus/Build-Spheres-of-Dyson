package abstracts;

public abstract class Satellite extends AstralObject {
	private int health;
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int h) {
		this.health=h;
	}
}
