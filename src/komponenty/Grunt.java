package komponenty;

import komponenty.Obliczenia.grunty;

public class Grunt {
	
	protected grunty grunt;
	protected double ws = -1;
	
	public Grunt(grunty grunt, double ws) {
		this.grunt = grunt;
		this.ws = ws;
	}

	public grunty getGrunt() {
		return grunt;
	}

	public void setGrunt(grunty grunt) {
		this.grunt = grunt;
	}

	public double getWs() {
		return ws;
	}

	public void setWs(double ws) {
		this.ws = ws;
	}
}
