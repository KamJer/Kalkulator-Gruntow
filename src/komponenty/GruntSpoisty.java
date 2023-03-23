package komponenty;

import komponenty.Obliczenia.grunty;
import komponenty.Obliczenia.konsGrupa;

public class GruntSpoisty extends Grunt {
	
	private konsGrupa konsolidacja;
	
	public GruntSpoisty(grunty grunt, konsGrupa konsolidacja, double ws) {
		super(grunt, ws);
		this.konsolidacja = konsolidacja;
	}

	public konsGrupa getKonsolidacja() {
		return konsolidacja;
	}

	public void setKonsolidacja(konsGrupa konsolidacja) {
		this.konsolidacja = konsolidacja;
	}

}
