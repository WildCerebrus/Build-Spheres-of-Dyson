//Main

public class BuildSpheresofDyson {

	public static void main(String[] args) throws Throwable {
		Interpret interpret = new Interpret(); //Interprète associé
		interpret.doMenu(); //affichage du menu des commandes disponibles
		while(!interpret.exit()){ //boucle de lecture des commandes
			try{
				interpret.printPrompt(); //affichage d'un '>' signalant l'attente de commande
				interpret.decode_execute(interpret.fetch()); //exécution de la commande
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
