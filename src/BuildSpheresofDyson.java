import java.util.ArrayList;

public class BuildSpheresofDyson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coordinates coord = new Coordinates(4,11.2,-3.29152439);
		Star sun = new Star(coord,"sun",1.989*(Math.pow(10, 19)));
		SwarmPart s1 = new SwarmPart(new Coordinates(Math.pow(10,8),0,0), 
				new Coordinates(0,Math.pow(10,6),1000), new Coordinates(), 8005.3, 0, 100, 1,sun,new Coordinates(1,1.5,8));
		Player toto = new Player(null,"Jammy",9000);
		toto.addSat(s1);
		ArrayList<Satellite> sats = new ArrayList<Satellite>();
		sats.add(s1);
		Corporation corp = new Corporation(null,"Bro Corp",18);
		corp.addPlayer(toto);
		System.out.println(corp.liste());		
	}
}
