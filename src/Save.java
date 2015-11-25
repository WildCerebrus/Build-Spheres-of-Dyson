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
	private String path="temp";
	public Save() {
	}
	public Save(String path){
		this.path=path+".bsod";
	}
	public Save(ArrayList<Corporation> corporations,ArrayList<Player> players,
			ArrayList<Satellite> satellites,ArrayList<Star> stars, String path){
		if(corporations != null) addCorporations(corporations);
		if(players != null) addPlayers(players);
		if(satellites != null) addSatellites(satellites);
		if(stars != null) addStars(stars);
		this.path=path;
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
			saver.print(this.toString());
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
	public String toString(){
		int i,j,k;
		String text="";
		Corporation corp=new Corporation();
		Player play=new Player();
		Satellite sate;
		Star star=new Star();
		for(i=0;i<this.corporations.size();i++){
			corp = this.corporations.get(i);
			text+=corp.getName();
			for(j=0;j<corp.getPlayers().size();j++){
				play=corp.getPlayers().get(j);
				text+="‡"+play.getPseudo();
				for(k=0;k<play.getSatellites().size();k++){
					sate=play.getSatellites().get(k);
					text+="†"+sate.getId();
					text+="Š"+sate.getPosition().getX();
					text+="Š"+sate.getPosition().getY();
					text+="Š"+sate.getPosition().getZ();
					text+="Š"+sate.getSpeed().getX();
					text+="Š"+sate.getSpeed().getY();
					text+="Š"+sate.getSpeed().getZ();
					text+="Š"+sate.getAcceleration().getX();
					text+="Š"+sate.getAcceleration().getY();
					text+="Š"+sate.getAcceleration().getZ();
					text+="Š"+sate.getMass();
					text+="Š"+sate.getEnergy();
					text+="Š"+sate.getState();
					text+="Š"+sate.getSun().getPosition().getX();
					text+="Š"+sate.getSun().getPosition().getY();
					text+="Š"+sate.getSun().getPosition().getZ();
					text+="Š"+sate.getSun().getName();
					text+="Š"+sate.getSun().getMass();
				}
				text+="Ž"+play.getFunds();
			}
			text+="Å"+corp.getPooledFunds();
		}
		text+="¶";
		for(j=0;j<players.size();j++){
			play=players.get(j);
			text+="‡"+play.getPseudo();
			for(k=0;k<play.getSatellites().size();k++){
				sate=play.getSatellites().get(k);
				text+="†"+sate.getId();
				text+="Š"+sate.getPosition().getX();
				text+="Š"+sate.getPosition().getY();
				text+="Š"+sate.getPosition().getZ();
				text+="Š"+sate.getSpeed().getX();
				text+="Š"+sate.getSpeed().getY();
				text+="Š"+sate.getSpeed().getZ();
				text+="Š"+sate.getAcceleration().getX();
				text+="Š"+sate.getAcceleration().getY();
				text+="Š"+sate.getAcceleration().getZ();
				text+="Š"+sate.getMass();
				text+="Š"+sate.getEnergy();
				text+="Š"+sate.getState();
				text+="Š"+sate.getSun().getPosition().getX();
				text+="Š"+sate.getSun().getPosition().getY();
				text+="Š"+sate.getSun().getPosition().getZ();
				text+="Š"+sate.getSun().getName();
				text+="Š"+sate.getSun().getMass();
			}
			text+="Ž"+play.getFunds();
		}
		text+="¶";
		for(k=0;k<this.satellites.size();k++){
			sate=this.satellites.get(k);
			text+="†"+sate.getId();
			text+="Š"+sate.getPosition().getX();
			text+="Š"+sate.getPosition().getY();
			text+="Š"+sate.getPosition().getZ();
			text+="Š"+sate.getSpeed().getX();
			text+="Š"+sate.getSpeed().getY();
			text+="Š"+sate.getSpeed().getZ();
			text+="Š"+sate.getAcceleration().getX();
			text+="Š"+sate.getAcceleration().getY();
			text+="Š"+sate.getAcceleration().getZ();
			text+="Š"+sate.getMass();
			text+="Š"+sate.getEnergy();
			text+="Š"+sate.getState();
			text+="Š"+sate.getSun().getPosition().getX();
			text+="Š"+sate.getSun().getPosition().getY();
			text+="Š"+sate.getSun().getPosition().getZ();
			text+="Š"+sate.getSun().getName();
			text+="Š"+sate.getSun().getMass();
		}
		text+="¶";
		for(k=0;k<this.stars.size();k++){
			star=this.stars.get(k);
			text+="†"+star.getName();
			text+="Š"+star.getPosition().getX();
			text+="Š"+star.getPosition().getY();
			text+="Š"+star.getPosition().getZ();
			text+="Š"+star.getMass();
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
}