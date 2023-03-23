package komponenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import komponenty.Obliczenia.grunty;

public class Loader {
	
	private List<String> table = new ArrayList<>(); 
	
	public Loader(String pathfile) {
		File file = new File(pathfile);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scan.hasNextLine()) {
			table.add(scan.nextLine());
		}
	}
	
	public String lookForGrunt(grunty grunt) {
		
		return null;
	}

	public List<String> getTable() {
		return table;
	}

	public void setTable(List<String> table) {
		this.table = table;
	}
}
