package data;

import java.util.ArrayList;

import abstracts.Element;

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
