package save;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BackUp {
	public BackUp(File f,String s) throws IOException {
		Files.write(f.toPath(),s.getBytes());
	}
}
