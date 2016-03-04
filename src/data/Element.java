package data;

public abstract class Element {
	private String name;
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name=n;
	}
	public String toString() {
		return this.name;
	}
}
