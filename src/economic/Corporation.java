package economic;

import java.util.ArrayList;

import abstracts.Economic;

public class Corporation extends Economic {
	private ArrayList<Economic> members;
	public ArrayList<Economic> getMembers() {
		return this.members;
	}
	public String toString() {
		return super.toString();
	}
}
