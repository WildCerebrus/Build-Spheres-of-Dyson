import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
//Classe de gestion d'un fichier de sauvegarde
public class Save {
	private ArrayList<Corporation> corporations=new ArrayList<Corporation>(); //liste des corporations
	private ArrayList<Player> players=new ArrayList<Player>(); //liste des joueurs
	private ArrayList<Satellite> satellites=new ArrayList<Satellite>(); //liste des satellites
	private ArrayList<Star> stars=new ArrayList<Star>(); //liste des astres
	private String path="temp.bsod"; //sauvegarde par défaut
	private BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	//de base les champs sont initialisés comme ci-dessus
	public Save() {	}
	//ou avec un path précis
	public Save(String path){
		this.path=path+".bsod";
	}
	//crée un listing en vue d'une sauvegarde
	public Save(ArrayList<Corporation> corporations,ArrayList<Player> players,
			ArrayList<Satellite> satellites,ArrayList<Star> stars, String path){
		if(corporations != null) addCorporations(corporations);
		if(players != null) addPlayers(players);
		if(satellites != null) addSatellites(satellites);
		if(stars != null) addStars(stars);
		this.path=path+".bsod";
	}
	//ajoute des corporations à la liste
	public void addCorporations(ArrayList<Corporation> corporations) {
		int i;
		for(i=0;i<corporations.size();i++) this.corporations.add(corporations.get(i));
	}
	//ajoute des joueurs à la liste
	public void addPlayers(ArrayList<Player> players) {
		int i;
		for(i=0;i<players.size();i++) this.players.add(players.get(i));
	}
	//ajoute des satellites à la liste
	public void addSatellites(ArrayList<Satellite> satellites) {
		int i;
		for(i=0;i<satellites.size();i++) this.satellites.add(satellites.get(i));
	}
	//ajoute des astres à la liste
	public void addStars(ArrayList<Star> stars){
		int i;
		for(i=0;i<stars.size();i++) this.stars.add(stars.get(i));
	}
	//retourne le chemin relatif du fichier de sauvegarde
	public String getPath() {
		return path;
	}
	//écrit la sauvegarde dans le fichier désigné par le path
	public void save(){
		PrintWriter saver;
		try
			{
			saver = new PrintWriter(new FileWriter(path));
			saver.print(this.toFile());
			saver.flush();
			saver.close();
		}
		catch (NullPointerException a)
			{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a)
			{
			System.out.println("Problème d'IO");
		}
	}
	//convertit les données de sauvegarde en texte interprétable par la suite
	public String toFile(){
		int i,j,k;
		String text="";
		Corporation corp=new Corporation();
		Player play=new Player();
		Satellite sate;
		Star star=new Star();
		for(i=0;i<this.corporations.size();i++){
			corp = this.corporations.get(i);
			if(i!=0) text+="Å";
			text+=corp.getName()+"‡";
			for(j=0;j<corp.getPlayers().size();j++){
				play=corp.getPlayers().get(j);
				if(j!=0)text+="Ž";
				text+=play.getPseudo()+"†";
				for(k=0;k<play.getSatellites().size();k++){
					sate=play.getSatellites().get(k);
					if(k!=0)text+="Š";
					text+=sate.getId();
					text+="±"+sate.getPosition().getX();
					text+="±"+sate.getPosition().getY();
					text+="±"+sate.getPosition().getZ();
					text+="±"+sate.getSpeed().getX();
					text+="±"+sate.getSpeed().getY();
					text+="±"+sate.getSpeed().getZ();
					text+="±"+sate.getAcceleration().getX();
					text+="±"+sate.getAcceleration().getY();
					text+="±"+sate.getAcceleration().getZ();
					text+="±"+sate.getMass();
					text+="±"+sate.getEnergy();
					text+="±"+sate.getState();
					text+="±"+sate.getSun().getPosition().getX();
					text+="±"+sate.getSun().getPosition().getY();
					text+="±"+sate.getSun().getPosition().getZ();
					text+="±"+sate.getSun().getName();
					text+="±"+sate.getSun().getMass();
					text+="±"+sate.getType();
					if(sate.getType().equals("SwarmPart")){
						text+="±"+((SwarmPart) sate).getDimensions().getLength();
						text+="±"+((SwarmPart) sate).getDimensions().getWidth();
						text+="±"+((SwarmPart) sate).getDimensions().getThickness();
					}
					text+="±"+sate.getModele();
				}
				text+="†"+play.getFunds();
				text+="†"+play.getFees();
			}
			text+="‡"+corp.getPooledFunds();
		}
		text+="¶";
		for(j=0;j<corp.getPlayers().size();j++){
			play=corp.getPlayers().get(j);
			if(j!=0)text+="Ž";
			text+=play.getPseudo()+"†";
			for(k=0;k<play.getSatellites().size();k++){
				sate=play.getSatellites().get(k);
				if(k!=0)text+="Š";
				text+=sate.getId();
				text+="±"+sate.getPosition().getX();
				text+="±"+sate.getPosition().getY();
				text+="±"+sate.getPosition().getZ();
				text+="±"+sate.getSpeed().getX();
				text+="±"+sate.getSpeed().getY();
				text+="±"+sate.getSpeed().getZ();
				text+="±"+sate.getAcceleration().getX();
				text+="±"+sate.getAcceleration().getY();
				text+="±"+sate.getAcceleration().getZ();
				text+="±"+sate.getMass();
				text+="±"+sate.getEnergy();
				text+="±"+sate.getState();
				text+="±"+sate.getSun().getPosition().getX();
				text+="±"+sate.getSun().getPosition().getY();
				text+="±"+sate.getSun().getPosition().getZ();
				text+="±"+sate.getSun().getName();
				text+="±"+sate.getSun().getMass();
				text+="±"+sate.getType();
				if(sate.getType().equals("SwarmPart")){
					text+="±"+((SwarmPart) sate).getDimensions().getLength();
					text+="±"+((SwarmPart) sate).getDimensions().getWidth();
					text+="±"+((SwarmPart) sate).getDimensions().getThickness();
				}
				text+="±"+sate.getModele();
			}
			text+="†"+play.getFunds();
			text+="†"+play.getFees();
		}
		text+="¶";
		for(k=0;k<play.getSatellites().size();k++){
			sate=play.getSatellites().get(k);
			if(k!=0)text+="Š";
			text+=sate.getId();
			text+="±"+sate.getPosition().getX();
			text+="±"+sate.getPosition().getY();
			text+="±"+sate.getPosition().getZ();
			text+="±"+sate.getSpeed().getX();
			text+="±"+sate.getSpeed().getY();
			text+="±"+sate.getSpeed().getZ();
			text+="±"+sate.getAcceleration().getX();
			text+="±"+sate.getAcceleration().getY();
			text+="±"+sate.getAcceleration().getZ();
			text+="±"+sate.getMass();
			text+="±"+sate.getEnergy();
			text+="±"+sate.getState();
			text+="±"+sate.getSun().getPosition().getX();
			text+="±"+sate.getSun().getPosition().getY();
			text+="±"+sate.getSun().getPosition().getZ();
			text+="±"+sate.getSun().getName();
			text+="±"+sate.getSun().getMass();
			text+="±"+sate.getType();
			if(sate.getType().equals("SwarmPart")){
				text+="±"+((SwarmPart) sate).getDimensions().getLength();
				text+="±"+((SwarmPart) sate).getDimensions().getWidth();
				text+="±"+((SwarmPart) sate).getDimensions().getThickness();
			}
			text+="±"+sate.getModele();
		}
		text+="¶";
		for(k=0;k<this.stars.size();k++){
			star=this.stars.get(k);
			if(k!=0)text+="Š";
			text+=star.getName();
			text+="±"+star.getPosition().getX();
			text+="±"+star.getPosition().getY();
			text+="±"+star.getPosition().getZ();
			text+="±"+star.getMass();
		}
		text+="¶";
		return text;
	}
	//lit le fichier désigné par Path et récupère la ligne cryptée
	public String read() {
		BufferedReader reader;
		String tmp = "";
		try
			{
			reader = new BufferedReader(new FileReader(this.path)) ;
			while (reader.ready()==true) 
				{
				tmp += reader.readLine() ; 
			}
		}
		catch (NullPointerException a)
			{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a) 
			{
			System.out.println("Problème d'IO");
		}
		return tmp;
	}
	//ajoute les données d'un texte de sauvegarde à la sauvegarde
	public void fromFile(){
		String text=this.read();
		String[] Arrays = text.split("¶");
		String[] Corporations = Arrays[0].split("Å");
		int i,j,k;
		String[] Corporation;
		String[] Players;
		String[] Player;
		String[] Satellites;
		String[] Satellite;
		String[] Stars;
		String[] Star;
		ArrayList<Star> Stas;
		ArrayList<Satellite> Sats;
		ArrayList<Player> Plas;
		ArrayList<Corporation> Cors=new ArrayList<Corporation>();
		for(i=0;i<Corporations.length;i++){
			Corporation = Corporations[i].split("‡");
			Players = Corporation[2].split("Ž");
			Plas = new ArrayList<Player>();
			for(j=0;j<Players.length;j++){
				Player = Players[j].split("†");
				Satellites = Player[2].split("Š");
				Sats = new ArrayList<Satellite>();
				for(k=0;k<Satellites.length;k++){
					Satellite = Satellites[k].split("±");
					if(Satellite[18].equals("SwarmPart")){
						Sats.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
								Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
								new Coordinates(Double.parseDouble(Satellite[4]),
								Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
								new Coordinates(Double.parseDouble(Satellite[7]),
								Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
								Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
								Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
								new Star(new Coordinates(Double.parseDouble(Satellite[13]),
								Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
								Satellite[16],Double.parseDouble(Satellite[17])), 
								new PanelDimensions(Double.parseDouble(Satellite[19]), 
								Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),
								Satellite[22]));
						this.satellites.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
								Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
								new Coordinates(Double.parseDouble(Satellite[4]),
								Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
								new Coordinates(Double.parseDouble(Satellite[7]),
								Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
								Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
								Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
								new Star(new Coordinates(Double.parseDouble(Satellite[13]),
								Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
								Satellite[16],Double.parseDouble(Satellite[17])),
								new PanelDimensions(Double.parseDouble(Satellite[19]), 
								Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),
								Satellite[22]));
					}
				}
				Plas.add(new Player(Sats,Player[0],Integer.parseInt(Player[2]),Integer.parseInt(Player[3])));
				this.players.add(new Player(Sats,Player[0],Integer.parseInt(Player[2]),
						Integer.parseInt(Player[3])));
			}
			Cors.add(new Corporation(Plas,Corporation[0],Integer.parseInt(Corporation[2])));
			this.corporations.add(new Corporation(Plas,Corporation[0],Integer.parseInt(Corporation[2])));
		}
		Players = Arrays[1].split("Ž");
		Plas = new ArrayList<Player>();
		for(j=0;j<Players.length;j++){
			Player = Players[j].split("†");
			Satellites = Player[2].split("Š");
			Sats = new ArrayList<Satellite>();
			for(k=0;k<Satellites.length;k++){
				Satellite = Satellites[k].split("±");
				if(Satellite[18].equals("SwarmPart")){
					Sats.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
							Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
							new Coordinates(Double.parseDouble(Satellite[4]),
							Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
							new Coordinates(Double.parseDouble(Satellite[7]),
							Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
							Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
							Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
							new Star(new Coordinates(Double.parseDouble(Satellite[13]),
							Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
							Satellite[16],Double.parseDouble(Satellite[17])),
							new PanelDimensions(Double.parseDouble(Satellite[19]), 
							Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),Satellite[22]));
					this.satellites.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
							Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
							new Coordinates(Double.parseDouble(Satellite[4]),
							Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
							new Coordinates(Double.parseDouble(Satellite[7]),
							Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
							Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
							Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
							new Star(new Coordinates(Double.parseDouble(Satellite[13]),
							Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
							Satellite[16],Double.parseDouble(Satellite[17])),
							new PanelDimensions(Double.parseDouble(Satellite[19]), 
							Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),Satellite[22]));
				}
			}
			Plas.add(new Player(Sats,Player[0],Integer.parseInt(Player[2]),Integer.parseInt(Player[3])));
			this.players.add(new Player(Sats,Player[0],Integer.parseInt(Player[2]),Integer.parseInt(Player[3])));
		}
		Satellites = Arrays[2].split("Š");
		Sats = new ArrayList<Satellite>();
		for(k=0;k<Satellites.length;k++){
			Satellite = Satellites[k].split("±");
			if(Satellite[18].equals("SwarmPart")){
				Sats.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
						Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
						new Coordinates(Double.parseDouble(Satellite[4]),
						Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
						new Coordinates(Double.parseDouble(Satellite[7]),
						Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
						Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
						Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
						new Star(new Coordinates(Double.parseDouble(Satellite[13]),
						Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
						Satellite[16],Double.parseDouble(Satellite[17])),
						new PanelDimensions(Double.parseDouble(Satellite[19]), 
						Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),Satellite[22]));
				this.satellites.add(new SwarmPart(new Coordinates(Double.parseDouble(Satellite[1]),
						Double.parseDouble(Satellite[2]),Double.parseDouble(Satellite[3])),
						new Coordinates(Double.parseDouble(Satellite[4]),
						Double.parseDouble(Satellite[5]),Double.parseDouble(Satellite[6])),
						new Coordinates(Double.parseDouble(Satellite[7]),
						Double.parseDouble(Satellite[8]),Double.parseDouble(Satellite[9])),
						Double.parseDouble(Satellite[10]),Double.parseDouble(Satellite[11]),
						Integer.parseInt(Satellite[12]),Integer.parseInt(Satellite[0]),
						new Star(new Coordinates(Double.parseDouble(Satellite[13]),
						Double.parseDouble(Satellite[14]),Double.parseDouble(Satellite[15])),
						Satellite[16],Double.parseDouble(Satellite[17])),
						new PanelDimensions(Double.parseDouble(Satellite[19]), 
						Double.parseDouble(Satellite[20]), Double.parseDouble(Satellite[21])),Satellite[22]));
			}
		}
		Stars = Arrays[3].split("Š");
		Stas = new ArrayList<Star>();
		for(k=0;k<Stars.length;k++){
			Star = Stars[k].split("±");
			Stas.add(new Star(new Coordinates(Double.parseDouble(Star[1]),Double.parseDouble(Star[2]),
					Double.parseDouble(Star[3])),Star[0],Double.parseDouble(Star[4])));
			this.stars.add(new Star(new Coordinates(Double.parseDouble(Star[1]),Double.parseDouble(Star[2]),
					Double.parseDouble(Star[3])),Star[0],Double.parseDouble(Star[4])));
		}
	}
	public void addCorporation(Corporation corp) { //adders
		this.corporations.add(corp);
	}
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	public ArrayList<Satellite> getSatellites() {
		return this.satellites;
	}
	public void addSatellite(SwarmPart sat) {
		this.satellites.add(sat);
	}
	public void addStar(Star sun) {
		this.stars.add(sun);
	}
	//afficheur des noms des objets de la sauvegarde
	public void displayName(int n) {
		int i;
		System.out.print("\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Corporations : \r");
		for(i=0;i<this.corporations.size();i++){
			this.corporations.get(i).displayName(n+1);
		}
		System.out.print("\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Joueurs : \r");
		for(i=0;i<this.players.size();i++){
			this.players.get(i).displayName(n+1);
		}
		System.out.print("\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Satellites : \r");
		for(i=0;i<this.satellites.size();i++){
			this.satellites.get(i).displayName(n+1);
		}
		System.out.print("\r");
		for(i=0;i<n;i++) System.out.print("\t");
		System.out.print("Astres : \r");
		for(i=0;i<this.stars.size();i++){
			this.stars.get(i).displayName(n+1);
		}
	}
	//mise à jour
	public void update(int n) {
		int i;
		for(i=0;i<this.corporations.size();i++){
			this.corporations.get(i).update(n);
		}
		for(i=0;i<this.players.size();i++){
			this.players.get(i).update(n);
		}
		for(i=0;i<this.satellites.size();i++){
			this.satellites.get(i).update(n);
		}
		for(i=0;i<this.stars.size();i++){
			this.stars.get(i).update(n);
		}
	}
	public Corporation seekCorporation(String s) { //chercheurs
		int i;
		for(i=0;i<this.corporations.size();i++){
			if(this.corporations.get(i).getName().equals(s)) return this.corporations.get(i);
		}
		return null;
	}
	public Player seekPlayer(String s){
		int i;
		for(i=0;i<this.players.size();i++){
			if(this.players.get(i).getPseudo().equals(s)) return this.players.get(i);
		}
		return null;
	}
	public Satellite seekSatellite(String s){
		int i;
		for(i=0;i<this.satellites.size();i++){
			if(this.satellites.get(i).getId()==Integer.parseInt(s)) return this.satellites.get(i); 
		}
		return null;
	}
	public Star seekStar(String s){
		int i;
		for(i=0;i<this.stars.size();i++){
			if(this.stars.get(i).getName().equals(s)) return this.stars.get(i);
		}
		return null;
	}
	//lancement d'un ajout
	public int doAdd() throws Exception {
		String s="";
		System.out.println("Quel type d'élément voulez-vous ajouter (c/j/s/a) ? ");
		s=this.in.readLine();
		switch(s){
			case "c" : return doAddCorp();
			case "j" : return doAddPlayer();
			case "s" : return doAddSat();
			case "a" : return doAddStar();
			default : throw new Exception("entrée incohérente");
		}
	}
	//ajout d'astre
	private int doAddStar() throws Exception {
		String s="";
		System.out.println("Quelle méthode voulez-vous utiliser (def/spl/cpl) ? ");
		s=this.in.readLine();
		switch(s){
			case "def" : return doAddStarDef();
			case "spl" : return doAddStarSpl();
			case "cpl" : return doAddStarCpl();
			default : throw new Exception("entrée incohérente");
		}
	}
	//méthode complète
	private int doAddStarCpl() throws NumberFormatException, IOException {
		String s="";
		System.out.println("Quel nom voulez-vous donnez ? ");
		s=in.readLine();
		System.out.println("Quel x ? ");
		double x=Double.parseDouble(in.readLine());
		System.out.println("Quel y ? ");
		double y=Double.parseDouble(in.readLine());
		System.out.println("Quel z ? ");
		double z=Double.parseDouble(in.readLine());
		System.out.println("Quelle masse ? ");
		double mass=Double.parseDouble(in.readLine());
		stars.add(new Star(new Coordinates(x,y,z),s,mass));
		return 0;
	}
	//méthode simple
	private int doAddStarSpl() throws IOException {
		String s="";
		System.out.println("Quel nom voulez-vous donnez ? ");
		s=this.in.readLine();
		stars.add(new Star(s));
		return 0;
	}
	//méthode par défaut
	private int doAddStarDef() {
		stars.add(new Star());
		return 0;
	}
	//ajout de satellite
	private int doAddSat() throws Exception {
		String s="";
		System.out.println("Voulez-vous ajouter un satellite à un joueur (j) ou créer un nouveau satellite (n) ? ");
		s=this.in.readLine();
		switch(s){
			case "j" : return doAddSatJ();
			case "n" : return doAddSatN();
			default : throw new Exception("entrée incohérente");
		}
	}
	//ajout d'un nouveau satellite
	private int doAddSatN() throws Exception {
		String s="";
		System.out.println("Quel type de satellite voulez-vous ajouter (sp) ? ");
		s=this.in.readLine();
		switch(s){
			case "sp" : return doAddSwarmPart();
			default : throw new Exception("entrée incohérente");
		}
	}
	//ajout d'une nouvelle unité d'un essaim
	private int doAddSwarmPart() throws Exception {
		String s="";
		System.out.println("Quelle méthode voulez-vous utiliser (def/spl) ? ");
		s=this.in.readLine();
		switch(s){
			case "def" : return doAddSwarmPartDef();
			case "spl" : return doAddSwarmPartSpl();
			default : throw new Exception("entrée incohérente");
		}
	}
	//méthode simple
	private int doAddSwarmPartSpl() throws IOException {
		String s="";
		System.out.println("Quel id voulez-vous donnez ? ");
		s=this.in.readLine();
		satellites.add(new SwarmPart(Integer.parseInt(s)));
		return 0;
	}
	//méthode par défaut
	private int doAddSwarmPartDef() {
		satellites.add(new SwarmPart());
		return 0;
	}
	//ajout d'un satellite à un joueur
	private int doAddSatJ() throws Exception {
		String s="";
		System.out.println("Quel satellite voulez-vous ajouter ? ");
		s=this.in.readLine();
		Satellite sat = this.seekSatellite(s);
		if(sat==null) throw new Exception("satellite inexistant");
		String t="";
		System.out.println("Chez quel joueur ? ");
		t=this.in.readLine();
		Player p = this.seekPlayer(t);
		if(p==null) throw new Exception("joueur inexistant");
		p.addSat(sat);
		return 0;
	}
	//ajout d'un joueur
	private int doAddPlayer() throws Exception {
		String s="";
		System.out.println("Voulez-vous ajouter un joueur dans une corporation (c) ou créer un nouveau joueur (n) ? ");
		s=this.in.readLine();
		switch(s){
			case "c" : return doAddPlayerC();
			case "n" : return doAddPlayerN();
			default : throw new Exception("entrée incohérente");
		}
	}
	//ajout d'un nouveau joueur
	private int doAddPlayerN() throws Exception {
		String s="";
		System.out.println("Quelle méthode voulez-vous utiliser (def/spl/cpl) ? ");
		s=this.in.readLine();
		switch(s){
			case "def" : return doAddPlayerDef();
			case "spl" : return doAddPlayerSpl();
			case "cpl" : return doAddPlayerCpl();
			default : throw new Exception("entrée incohérente");
		}
	}
	//méthode complète
	private int doAddPlayerCpl() throws IOException {
		String s="";
		System.out.println("Quel pseudo voulez-vous donnez ? ");
		s=in.readLine();
		String t="";
		System.out.println("Quels fonds voulez-vous attribuer ? ");
		t=in.readLine();
		players.add(new Player(new ArrayList<Satellite>(),s,Integer.parseInt(t),0));
		return 0;
	}
	//méthode simple
	private int doAddPlayerSpl() throws IOException {
		String s="";
		System.out.println("Quel pseudo voulez-vous donnez ? ");
		s=this.in.readLine();
		players.add(new Player(s));
		return 0;
	}
	//méthode par défaut
	private int doAddPlayerDef() {
		players.add(new Player());
		return 0;
	}
	//ajout d'un joueur à une corporation
	private int doAddPlayerC() throws Exception {
		String s="";
		System.out.println("Quel joueur voulez-vous ajouter ? ");
		s=this.in.readLine();
		Player p = this.seekPlayer(s);
		if(p==null) throw new Exception("joueur inexistant");
		String t="";
		System.out.println("Dans quelle corporation ? ");
		t=this.in.readLine();
		Corporation c= this.seekCorporation(t);
		if(c==null) throw new Exception("corporation inexistante");
		c.addPlayer(p);
		return 0;
	}
	//ajout d'une nouvelle corporation
	private int doAddCorp() throws Exception {
		String s="";
		System.out.println("Quelle méthode voulez-vous utiliser (def/spl/cpl) ? ");
		s=this.in.readLine();
		switch(s){
			case "def" : return doAddCorpDef();
			case "spl" : return doAddCorpSpl();
			case "cpl" : return doAddCorpCpl();
			default : throw new Exception("entrée incohérente");
		}
	}
	//méthode complète
	private int doAddCorpCpl() throws IOException {
		String s="";
		System.out.println("Quel nom voulez-vous donnez ? ");
		s=in.readLine();
		String t="";
		System.out.println("Quels fonds voulez-vous attribuer ? ");
		t=in.readLine();
		corporations.add(new Corporation(new ArrayList<Player>(),s,Integer.parseInt(t)));
		return 0;
	}
	//méthode simple
	private int doAddCorpSpl() throws IOException {
		String s="";
		System.out.println("Quel nom voulez-vous donnez ? ");
		s=this.in.readLine();
		corporations.add(new Corporation(s));
		return 0;
	}
	//méthode par défaut
	private int doAddCorpDef() {
		corporations.add(new Corporation());
		return 0;
	}
}