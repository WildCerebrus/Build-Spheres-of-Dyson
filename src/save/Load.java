package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Load {
	private String text;
	public Load(String s) throws IOException {
		FileInputStream f=new FileInputStream(s);
		text="";
		char c;
		while((c=(char) f.read())!=0) text+=c;
		f.close();
	}
	public Load(File i) throws IOException {
		FileInputStream f=new FileInputStream(i);
		text="";
		char c;
		while((c=(char) f.read())!=0) text+=c;
		f.close();
	}
	public String getText() {
		return this.text;
	}
}
