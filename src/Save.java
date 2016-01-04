import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {
	private ArrayList<Corporation> corporations=new ArrayList<Corporation>();
	private ArrayList<Player> players=new ArrayList<Player>();
	private ArrayList<Satellite> satellites=new ArrayList<Satellite>();
	private ArrayList<Star> stars=new ArrayList<Star>();
	private String path="temp.bsod";
	public Save() {
		this.fromFile();
	}
	public Save(String path){
		this.path=path+".bsod";
		this.fromFile();
	}
	public Save(ArrayList<Corporation> corporations,ArrayList<Player> players,
			ArrayList<Satellite> satellites,ArrayList<Star> stars, String path){
		if(corporations != null) addCorporations(corporations);
		if(players != null) addPlayers(players);
		if(satellites != null) addSatellites(satellites);
		if(stars != null) addStars(stars);
		this.path=path+".bsod";
	}
	public void addCorporations(ArrayList<Corporation> corporations) {
		int i;
		for(i=0;i<corporations.size();i++) this.corporations.add(corporations.get(i));
	}
	public void addPlayers(ArrayList<Player> players) {
		int i;
		for(i=0;i<players.size();i++) this.players.add(players.get(i));
	}
	public void addSatellites(ArrayList<Satellite> satellites) {
		int i;
		for(i=0;i<satellites.size();i++) this.satellites.add(satellites.get(i));
	}
	public void addStars(ArrayList<Star> stars){
		int i;
		for(i=0;i<stars.size();i++) this.stars.add(stars.get(i));
	}
	public String getPath() {
		return path;
	}
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
				}
				text+="†"+play.getFunds();
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
			}
			text+="†"+play.getFunds();
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
								Satellite[16],Double.parseDouble(Satellite[17]))));
					}
				}
				Plas.add(new Player(Sats,Player[0],Integer.parseInt(Player[2])));
			}
			Cors.add(new Corporation(Plas,Corporation[0],Integer.parseInt(Corporation[2])));
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
							Satellite[16],Double.parseDouble(Satellite[17]))));
				}
			}
			Plas.add(new Player(Sats,Player[0],Integer.parseInt(Player[2])));
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
						Satellite[16],Double.parseDouble(Satellite[17]))));
			}
		}
		Stars = Arrays[3].split("Š");
		Stas = new ArrayList<Star>();
		for(k=0;k<Stars.length;k++){
			Star = Stars[k].split("±");
			Stas.add(new Star(new Coordinates(Double.parseDouble(Star[1]),Double.parseDouble(Star[2]),
					Double.parseDouble(Star[3])),Star[0],Double.parseDouble(Star[4])));
		}
	}
}