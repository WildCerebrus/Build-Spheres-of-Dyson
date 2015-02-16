
public class BSoD {

	public static void main(String[] args) {
		
		Coordonnees pos = new Coordonnees(170.3,42,0);
		Coordonnees vit = new Coordonnees();
		Satellite S1 = new Satellite(pos,vit,"testeur");
		S1.setweight(73152);
		S1.setmodel(28);
		S1.setname("l'étoile noire");
		S1.setsize(53);
		//System.out.println(S1);
		LSatellite L1 = new LSatellite("L1");
		L1.add(S1);
		//System.out.println(L1);
		Player J1 = new Player("Jacques",0,L1,17);
		//System.out.println(J1.getsats());
		System.out.println(J1);
		Player J2 = new Player("Jean-Michel",1);
		System.out.println(J2);
	}

}
