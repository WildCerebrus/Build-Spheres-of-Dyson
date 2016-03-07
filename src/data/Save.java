package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import abstracts.Element;
import save.Load;

public class Save {
	private String save;
	private ArrayList<Element> elements;
	public Save() {
		this.save="";
		this.elements= new ArrayList<Element>();
	}
	public Save(String s) {
		this.save=s;
		this.elements= new ArrayList<Element>();
	}
	public Save(Save s) {
		this.save=s.getSave();
		this.elements=s.getElements();
	}
	public void load(String s) throws IOException {
		this.save=new Load(s).getText();
	}
	public void load(File f) throws IOException {
		this.save=new Load(f).getText();
	}
	public String getSave() {
		return this.save;
	}
	public ArrayList<Element> getElements() {
		return this.elements;
	}
	public String toString() {
		return this.elements.toString();
	}
}
