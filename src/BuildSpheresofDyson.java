

public class BuildSpheresofDyson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Save test = new Save("test");
		Corporation corp = new Corporation("Bro Corp");
		test.addCorporation(corp);
		Player player = new Player("Jordan");
		corp.addPlayer(player);
		test.addPlayer(player);
		SwarmPart sat = new SwarmPart(test.getSatellites().size());
		sat.setDimensions(new PanelDimensions(120,40,2));
		player.addSat(sat);
		Star sun = new Star("Soleil");
		sat.setSun(sun);
		test.addStar(sun);
		test.addSatellite(sat);
		test.displayName(0);
		test.update(1);
		test.displayName(0);
	}
}
