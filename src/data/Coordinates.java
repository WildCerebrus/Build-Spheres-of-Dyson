package data;

public class Coordinates {
	private double x;
	private double y;
	private double z;
	public Coordinates() {
		this.x=(Math.random()-0.5)*Math.pow(10, 12);
		this.y=(Math.random()-0.5)*Math.pow(10, 12);
		this.z=(Math.random()-0.5)*Math.pow(10, 12);
	}
	public Coordinates(Coordinates c) {
		this.x=c.getX();
		this.y=c.getY();
		this.z=c.getZ();
	}
	public Coordinates(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void move(double dx, double dy, double dz) {
		this.x+=dx;
		this.y+=dy;
		this.z+=dz;
	}
	public String toString() {
		return "x : "+this.x+" y : "+this.y+" z : "+this.z;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getZ() {
		return this.z;
	}
}
