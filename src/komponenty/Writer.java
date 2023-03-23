package komponenty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

	public static void writeTable(String pathname, List<String> text) {
		File file = new File(pathname);
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file);
			for (int i = 0; i < text.size(); i++) {
				writer.write(text.get(i) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
