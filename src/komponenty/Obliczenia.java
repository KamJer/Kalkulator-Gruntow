package komponenty;

import java.awt.geom.Point2D;

import analitycalGeometry.objects.Line;

public class Obliczenia {

	public enum grunty {
		Pd("Pd"), Ppi("Ppi"), Ps("Ps"), Pr("Pr"), ¯("¯"), Po("Po"), Ph("Ph"),

		¯g("¯g"), Pog("Pog"), Pg("Pg"), Pip("Ppi"), Pi("Pi"), Gp("Gp"), G("G"), Gpi("Gpi"), Gpz("Gpz"), Gz("Gz"),
		Gpiz("Gpiz"), Ip("Ip"), I("I"), Ipi("Ipi");

		private String name;

		grunty(String name) {
			this.name = name;
		}
		
		public boolean compere(String string) {
			return string.equals(name);
		}

		public String getName() {
			return name;
		}
	}

	public enum konsGrupa {
		A("A"), B("B"), C("C"), D("D");
		
		private String name;
		
		konsGrupa(String name) {
			this.name = name;
		}
		
		public boolean compere(String string) {
			return string.equals(name);
		}

		public String getName() {
			return name;
		}
	}

	public enum stany {
		zg, szg, ln,

		pzw, tpl, pl, mpl
	}

	public enum wilgotnosc {
		mw("mw"), w("w"), m("m");
		
		private String name;
		
		wilgotnosc(String name) {
			this.name = name;
		}
		
		public boolean compere(String string) {
			return string.equals(name);
		}

		public String getName() {
			return name;
		}
	}

	/**
	 * Zwraca parametry gruntów
	 * 
	 * @param grunt - grunt do sprawdzenia
	 * @param ws    - wspczynnik gruntu
	 * @param wilg  - wilgotnoœæ gruntu
	 * @return - prametry w postaci tablicy {gêstoœæ szkieletu, gêstoœæ
	 *         objêtoœciowa, wilgotnoœæ}
	 */
	public static double[] parametry(grunty grunt, double ws, wilgotnosc wilg) {
		if (grunt == grunty.¯ || grunt == grunty.Po) {
			if (stany.zg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.85, 3 };
				case w:
					return new double[] { 2.65, 2, 10 };
				case m:
					return new double[] { 2.65, 2.10, 14 };
				default:
					break;
				}
			} else if (stany.szg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.75, 4 };
				case w:
					return new double[] { 2.65, 1.9, 12 };
				case m:
					return new double[] { 2.65, 2.05, 18 };
				default:
					break;
				}
			} else if (stany.ln == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.70, 5 };
				case w:
					return new double[] { 2.65, 1.85, 15 };
				case m:
					return new double[] { 2.65, 2, 23 };
				default:
					break;
				}
			}
		} else if (grunt == grunty.Pr || grunt == grunty.Ps) {
			if (stany.zg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.80, 4 };
				case w:
					return new double[] { 2.65, 1.9, 12 };
				case m:
					return new double[] { 2.65, 2.05, 18 };
				default:
					break;
				}
			} else if (stany.szg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.70, 5 };
				case w:
					return new double[] { 2.65, 1.85, 14 };
				case m:
					return new double[] { 2.65, 2.00, 22 };
				default:
					break;
				}
			} else if (stany.ln == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.65, 6 };
				case w:
					return new double[] { 2.65, 1.80, 15 };
				case m:
					return new double[] { 2.65, 1.95, 25 };
				default:
					break;
				}
			}
		} else if (grunt == grunty.Pd || grunt == grunty.Ppi) {
			if (stany.zg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.70, 5 };
				case w:
					return new double[] { 2.65, 1.85, 14 };
				case m:
					return new double[] { 2.65, 2, 22 };
				default:
					break;
				}
			} else if (stany.szg == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.65, 6 };
				case w:
					return new double[] { 2.65, 1.75, 16 };
				case m:
					return new double[] { 2.65, 1.90, 24 };
				default:
					break;
				}
			} else if (stany.ln == stan(grunt, ws)) {
				switch (wilg) {
				case mw:
					return new double[] { 2.65, 1.60, 7 };
				case w:
					return new double[] { 2.65, 1.70, 19 };
				case m:
					return new double[] { 2.65, 1.85, 28 };
				default:
					break;
				}
			}
		} else if (grunt == grunty.¯g || grunt == grunty.Pog) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.65, 6, 2.25 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.65, 9, 2.20 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.65, 15, 2.10 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.65, 18, 2.05 };
			}
		} else if (grunt == grunty.Pg) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.65, 10, 2.20 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.65, 13, 2.15 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.65, 16, 2.10 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.65, 19, 2.05 };
			}
		} else if (grunt == grunty.Pip) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.66, 14, 2.15 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.66, 18, 2.10 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.66, 20, 2.05 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.66, 22, 2.00 };
			}
		} else if (grunt == grunty.Pi) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.67, 18, 2.10 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.67, 22, 2.05 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.67, 24, 2.00 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.67, 26, 1.95 };
			}
		} else if (grunt == grunty.Gp) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.67, 9, 2.25 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.67, 12, 2.20 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.67, 17, 2.10 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.67, 24, 2.00 };
			}
		} else if (grunt == grunty.G) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.67, 13, 2.20 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.67, 16, 2.15 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.67, 21, 2.05 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.67, 27, 1.95 };
			}
		} else if (grunt == grunty.Gpi) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.68, 17, 2.15 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.68, 20, 2.10 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.68, 25, 2.00 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.68, 32, 1.90 };
			}
		} else if (grunt == grunty.Gpz) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.68, 11, 2.25 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.68, 14, 2.15 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.68, 20, 2.05 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.68, 30, 1.95 };
			}
		} else if (grunt == grunty.Gz) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.69, 15, 2.20 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.69, 18, 2.10 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.69, 24, 2.00 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.69, 35, 1.90 };
			}
		} else if (grunt == grunty.Gpiz) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.71, 18, 2.15 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.71, 22, 2.00 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.71, 28, 1.90 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.71, 42, 1.80 };
			}
		} else if (grunt == grunty.Ip) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.71, 14, 2.20 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.71, 18, 2.10 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.71, 25, 1.95 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.71, 40, 1.80 };
			}
		} else if (grunt == grunty.I) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.72, 19, 2.15 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.72, 27, 2.00 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.72, 34, 1.85 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.72, 50, 1.75 };
			}
		} else if (grunt == grunty.Ipi) {
			if (stany.pzw == stan(grunt, ws)) {
				return new double[] { 2.75, 25, 2.05 };
			} else if (stany.tpl == stan(grunt, ws)) {
				return new double[] { 2.75, 33, 1.90 };
			} else if (stany.pl == stan(grunt, ws)) {
				return new double[] { 2.75, 42, 1.80 };
			} else if (stany.mpl == stan(grunt, ws)) {
				return new double[] { 2.75, 50, 1.70 };
			}
		}
		return null;
	}

	/**
	 * Oblicza k¹t tarcia wewnêtrznego ska³
	 * 
	 * @param grunt - grunt jaki jest do obliczenia
	 */
	public static double angle(Grunt grunt, double ws) {
		double angle = -1;
//		warstosci a i b w tych liniach poni¿ej zosta³y obliczone z puntów odczytanych z wykresów w normie
		Line pdPpi = new Line(5, 28);
		Line prPs = new Line(6.667, 29.667);
		Line po¯ = new Line(7.5, 34.75);

		Line A = new Line(-17.17548514, 24.92896107);
		Line B = new Line(-18.78924893, 22.09314729);
		Line C = new Line(-16.07311692, 18.02205606);
		Line D = new Line(-13.38114126, 12.97049366);

//		sprawdzanie z jakim gruntem mamy do czynienia i wykonanie obliczeñ
		if (grunt instanceof GruntSpoisty) {
			GruntSpoisty gruntS = (GruntSpoisty) grunt;
			switch (gruntS.getKonsolidacja()) {
			case A:
				angle = A.findY(ws);
				break;
			case B:
				angle = B.findY(ws);
				break;
			case C:
				angle = C.findY(ws);
				break;
			case D:
				angle = D.findY(ws);
				break;
			default:
				break;
			}
		} else if (grunt instanceof Grunt) {
			switch (grunt.getGrunt()) {
			case Pd:
				angle = pdPpi.findY(ws);
				break;
			case Ppi:
				angle = pdPpi.findY(ws);
				break;
			case Ps:
				angle = prPs.findY(ws);
				break;
			case Pr:
				angle = prPs.findY(ws);
				break;
			case ¯:
				angle = po¯.findY(ws);
				break;
			case Po:
				angle = po¯.findY(ws);
				break;
			default:
				break;
			}
		}

		return angle;
	}

	/**
	 * Oblicza wytrzyma³oœæ grutnu
	 * 
	 * @param kons - grunty do obliczenia
	 * @param ws   - wspó³czynnik gruntu Id lub Il
	 * @return - wytrzyma³oœæ na œcinanie
	 */
	public static double cu(Grunt kons, double ws) {
		double resistance = -1;
		if (kons instanceof GruntSpoisty) {
//		pkt poniej zosta³y odczytane z wykresu z normy
			Point2D.Double[] pomA = { new Point2D.Double(0, 50),
//				new Point2D.Double(0.05, 47.1170744380091),
					new Point2D.Double(0.1, 44.4115465060155),
//				new Point2D.Double(0.15, 41.8631660986903),
					new Point2D.Double(0.2, 39.4770643021863),
//				new Point2D.Double(0.25, 37.1135596069502),
					new Point2D.Double(0.3, 34.979799424373),
//				new Point2D.Double(0.35, 32.9568898329691),
					new Point2D.Double(0.4, 31.1172437834069),
//				new Point2D.Double(0.45, 29.28312728273),
					new Point2D.Double(0.5, 27.6381415470423),
//				new Point2D.Double(0.55, 25.8874948423675),
					new Point2D.Double(0.6, 24.4169988737732),
//				new Point2D.Double(0.65, 22.8983602549017),
					new Point2D.Double(0.7, 21.6058563792703), new Point2D.Double(0.75, 20.1141421906005) };

			Point2D.Double[] pomB = { new Point2D.Double(0, 40),
//				new Point2D.Double(0.05, 37.6514815777007),
					new Point2D.Double(0.1, 35.3477001734032),
//				new Point2D.Double(0.15, 33.2775035530357),
					new Point2D.Double(0.2, 31.3970575090724),
//				new Point2D.Double(0.25, 29.5612573926066),
					new Point2D.Double(0.3, 27.8338904878528),
//				new Point2D.Double(0.35, 26.1802955514464),
					new Point2D.Double(0.4, 24.7390461037916),
//				new Point2D.Double(0.45, 23.2504546357565),
					new Point2D.Double(0.5, 21.901624984358),
//				new Point2D.Double(0.55, 20.4138331524978),
					new Point2D.Double(0.6, 19.1337885911439),
//				new Point2D.Double(0.65, 17.7294191359628),
					new Point2D.Double(0.7, 16.6393303419797), new Point2D.Double(0.75, 15.3178909168916) };

			Point2D.Double[] pomC = { new Point2D.Double(0, 30),
//				new Point2D.Double(0.05, 5.35494020272082),
					new Point2D.Double(0.1, 21.5532991294088),
//				new Point2D.Double(0.15, 18.7847853660773),
					new Point2D.Double(0.2, 16.7679078996764),
//				new Point2D.Double(0.25, 14.9847945352018),
					new Point2D.Double(0.3, 13.4849568279733),
//				new Point2D.Double(0.35, 12.0445619450769),
					new Point2D.Double(0.4, 10.9467902536692),
//				new Point2D.Double(0.45, 9.83388602778245),
					new Point2D.Double(0.5, 8.84838842310374),
//				new Point2D.Double(0.55, 8.02940232590125),
					new Point2D.Double(0.6, 7.34554604122348),
//				new Point2D.Double(0.65, 6.68429176154164),
					new Point2D.Double(0.7, 5.94741593521515), new Point2D.Double(0.75, 5.35494020272082) };

			Point2D.Double[] pomD = { new Point2D.Double(0, 60),
//			new Point2D.Double(0.05, 56.9744945520119),
					new Point2D.Double(0.1, 54.2487352294464),
//			new Point2D.Double(0.15, 51.5576814340511),
					new Point2D.Double(0.2, 48.9417937396092),
//			new Point2D.Double(0.25, 46.2606782095756),
					new Point2D.Double(0.3, 44.0317131160729),
//			new Point2D.Double(0.35, 41.5398016412733),
					new Point2D.Double(0.4, 39.3341407604712),
//			new Point2D.Double(0.45, 37.1318978559531),
					new Point2D.Double(0.5, 35.020692182556),
//			new Point2D.Double(0.55, 32.8566407384202),
					new Point2D.Double(0.6, 31.0056937020683),
//			new Point2D.Double(0.65, 28.954261350612),
					new Point2D.Double(0.7, 27.252006650101), new Point2D.Double(0.75, 25.3608841774075) };

//		interpolowanie wartoœci pomiêdzy punktami interpolacj¹ wielomianow¹ (Lagrange'a)
			switch (((GruntSpoisty) kons).getKonsolidacja()) {
			case A:
				resistance = lagrangeInterpolation(pomA, ws);
				break;
			case B:
				resistance = lagrangeInterpolation(pomB, ws);
				break;
			case C:
				resistance = lagrangeInterpolation(pomC, ws);
				break;
			case D:
				resistance = lagrangeInterpolation(pomD, ws);
				break;
			default:
				break;
			}
		}
		return resistance;
	}

	/**
	 * oblicza modu³ pierwotnego odkszta³cenia gruntu
	 * 
	 * @param grunt - grunt do obliczenia
	 * @param ws    - wspó³czynnik gruntu Id lub Il
	 * @return - modu³
	 */
	public static double E0(Grunt grunt, double ws) {
		Point2D.Double[] pom¯Po = { new Point2D.Double(0.2, 88818.4011026878),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 103982.081323225),
//				new Point2D.Double(0.35, 111830.461750517),
				new Point2D.Double(0.4, 120274.638180565),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 137691.592005513),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 156138.869745003),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 175638.869745003),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 196070.640937285),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 218796.002756719),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(1, 241951.412818746) };

		Point2D.Double[] pomPrPs = { new Point2D.Double(0.2, 45571.6747070986),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 56242.2467263956),
//				new Point2D.Double(0.35, 111830.461750517),
				new Point2D.Double(0.4, 67844.5899379738),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 80719.1592005514),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 94516.5403170228),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 109863.8869745),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 126756.71950379),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 146865.954514128),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(1, 171656.44383184) };

		Point2D.Double[] pomPdPpi = { new Point2D.Double(0.2, 25919.3659545141),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 32679.1867677464),
//				new Point2D.Double(0.35, 111830.461750517),
				new Point2D.Double(0.4, 39510.6822880772),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 47197.794624397),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 55659.8897312199),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 65165.7477601654),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 75352.5155065472),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 88558.5802894556),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(1, 105330.461750517) };

		Point2D.Double[] pomA = { new Point2D.Double(0, 67384.9037189475),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.1, 49963.104512715),
//				new Point2D.Double(0.35, 48143.0048242591),
				new Point2D.Double(0.2, 37978.3183889461),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.3, 29716.8161105395),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.4, 23902.6899897104),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.5, 19509.5546082611),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.6, 15894.3113332353),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.7, 13030.7217404086),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(0.75, 11818.6094370131), };

		Point2D.Double[] pomB = { new Point2D.Double(0, 50115.390268999),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.1, 36262.5312362193),
//				new Point2D.Double(0.35, 48143.0048242591),
				new Point2D.Double(0.2, 27961.928560929),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.3, 22219.3150080847),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.4, 18161.6198735852),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.5, 15041.3053064824),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.6, 12438.5565191827),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.7, 10302.9545788623),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(0.75, 9386.15316772012), };

		Point2D.Double[] pomC = { new Point2D.Double(0, 34199.4708216963),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.1, 26361.384683228),
//				new Point2D.Double(0.35, 48143.0048242591),
				new Point2D.Double(0.2, 20867.2644421579),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.3, 16716.9631045127),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.4, 13668.675584301),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.5, 11263.4866970454),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.6, 9186.0208731442),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.7, 7457.37174775834),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(0.75, 6679.47964133471), };

		Point2D.Double[] pomD = { new Point2D.Double(0, 22599.0004409819),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.1, 17982.0667352639),
//				new Point2D.Double(0.35, 48143.0048242591),
				new Point2D.Double(0.2, 14199.6178156696),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.3, 11127.1497868587),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.4, 8844.40687931795),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.5, 7076.142878142),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.6, 5666.9851536087),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.7, 4554.16727914156),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(0.75, 4055.12273996766), };

		if (grunt instanceof GruntSpoisty) {
			switch (((GruntSpoisty) grunt).getKonsolidacja()) {
			case A:
				return lagrangeInterpolation(pomA, ws);
			case B:
				return lagrangeInterpolation(pomB, ws);
			case C:
				return lagrangeInterpolation(pomC, ws);
			case D:
				return lagrangeInterpolation(pomD, ws);
			default:
				break;
			}
		} else if (grunt instanceof Grunt) {
			switch (grunt.getGrunt()) {
			case ¯:
				return lagrangeInterpolation(pom¯Po, ws);
			case Po:
				return lagrangeInterpolation(pom¯Po, ws);
			case Pr:
				return lagrangeInterpolation(pomPrPs, ws);
			case Ps:
				return lagrangeInterpolation(pomPrPs, ws);
			case Pd:
				return lagrangeInterpolation(pomPdPpi, ws);
			case Ppi:
				return lagrangeInterpolation(pomPdPpi, ws);
			default:
				break;
			}
		}
		return -1;
	}

	/**
	 * Oblicza edometyczny modu³ œciœliwoœci pierwotnej
	 * 
	 * @param grunt - grunt do obliczenia
	 * @param ws    - wspó³czynnik gruntu Id lub Il
	 * @return - modu³
	 */
	public static double M0(Grunt grunt, double ws) {
		Point2D.Double[] pom¯Po = { new Point2D.Double(0.2, 99166.4369400414),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 116534.114403859),
//				new Point2D.Double(0.35, 111830.461750517),
				new Point2D.Double(0.4, 134640.937284631),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 154324.603721571),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 174953.480358374),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 196070.640937285),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 218809.4417643),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 243649.207443143),
//				new Point2D.Double(0.95, 229923.50103377),
		};

		Point2D.Double[] pomPrPs = { new Point2D.Double(0.2, 54934.183321847),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 67701.2405237767),
//				new Point2D.Double(0.35, 111830.461750517),
				new Point2D.Double(0.4, 81073.0530668505),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 96075.4651964163),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 112350.103376981),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 130640.592694693),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 150790.144727774),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 175876.292212267),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(1, 206351.481736733) };

		Point2D.Double[] pomPdPpi = { new Point2D.Double(0.2, 35676.0854583046),
//				new Point2D.Double(0.25, 96236.733287388),
				new Point2D.Double(0.3, 43784.2866988284), new Point2D.Double(0.35, 48143.0048242591),
				new Point2D.Double(0.4, 52649.5520330806),
//				new Point2D.Double(0.45, 128674.017918677),
				new Point2D.Double(0.5, 62545.1412818746),
//				new Point2D.Double(0.55, 146722.605099931),
				new Point2D.Double(0.6, 73878.7043418332),
//				new Point2D.Double(0.65, 165626.809097174),
				new Point2D.Double(0.7, 86668.1598897312),
//				new Point2D.Double(0.75, 185628.532046864),
				new Point2D.Double(0.8, 101361.474844935),
//				new Point2D.Double(0.85, 207180.22053756),
				new Point2D.Double(0.9, 119687.801516196),
//				new Point2D.Double(0.95, 229923.50103377),
				new Point2D.Double(1, 141983.115093039) };

		Point2D.Double[] pomA = { new Point2D.Double(0, 81701.0900053686), new Point2D.Double(0.05, 69338.6375837712),
				new Point2D.Double(0.10, 59808.5101249254), new Point2D.Double(0.15, 51832.4697338022),
				new Point2D.Double(0.20, 45305.4065955278), new Point2D.Double(0.25, 39999.1555022047),
				new Point2D.Double(0.30, 35557.36854487), new Point2D.Double(0.35, 31701.6328968084),
				new Point2D.Double(0.40, 28377.5990927681), new Point2D.Double(0.45, 25509.8957045223),
				new Point2D.Double(0.50, 22991.8747247842), new Point2D.Double(0.55, 20698.9425681178),
				new Point2D.Double(0.60, 18685.9614305793), new Point2D.Double(0.65, 16972.4150827306),
				new Point2D.Double(0.70, 15487.0339427792), new Point2D.Double(0.75, 14171.3666990391), };

		Point2D.Double[] pomB = { new Point2D.Double(0, 65101.9429481418), new Point2D.Double(0.05, 55159.5799226681),
				new Point2D.Double(0.10, 47704.4740286767), new Point2D.Double(0.15, 41669.119731691),
				new Point2D.Double(0.20, 36665.3798128834), new Point2D.Double(0.25, 32636.853883785),
				new Point2D.Double(0.30, 29254.3687680587), new Point2D.Double(0.35, 26375.3853021191),
				new Point2D.Double(0.40, 23804.5530495419), new Point2D.Double(0.45, 21642.3672479626),
				new Point2D.Double(0.50, 19697.0665765869), new Point2D.Double(0.55, 17884.0504527111),
				new Point2D.Double(0.60, 16214.0862232249), new Point2D.Double(0.65, 14766.647162789),
				new Point2D.Double(0.70, 13461.7472659384), new Point2D.Double(0.75, 12235.8079129443), };

		Point2D.Double[] pomC = { new Point2D.Double(0, 48057.23282201), new Point2D.Double(0.05, 42158.2649189584),
				new Point2D.Double(0.10, 37006.8585285229), new Point2D.Double(0.15, 32596.3481502482),
				new Point2D.Double(0.20, 28873.4097804909), new Point2D.Double(0.25, 25778.5666459564),
				new Point2D.Double(0.30, 23155.4358513443), new Point2D.Double(0.35, 20766.1103034763),
				new Point2D.Double(0.40, 18892.5919446975), new Point2D.Double(0.45, 17195.4529825852),
				new Point2D.Double(0.50, 15623.9330675176), new Point2D.Double(0.55, 14164.1884677794),
				new Point2D.Double(0.60, 12944.4018844365), new Point2D.Double(0.65, 11801.5249217332),
				new Point2D.Double(0.70, 10775.0378515976), new Point2D.Double(0.75, 9893.14086826438), };

		Point2D.Double[] pomD = { new Point2D.Double(0, 40125.8000108578), new Point2D.Double(0.05, 35453.7969224087),
				new Point2D.Double(0.10, 31141.7308585527), new Point2D.Double(0.15, 27425.4579892508),
				new Point2D.Double(0.20, 24185.5120371096), new Point2D.Double(0.25, 21523.4137013735),
				new Point2D.Double(0.30, 19252.0162384862), new Point2D.Double(0.35, 17214.9367531473),
				new Point2D.Double(0.40, 15474.2156726727), new Point2D.Double(0.45, 13986.2708787),
				new Point2D.Double(0.50, 12625.9960549889), new Point2D.Double(0.55, 11374.4201617816),
				new Point2D.Double(0.60, 10198.2156968012), new Point2D.Double(0.65, 9209.67070618112),
				new Point2D.Double(0.70, 8292.90802815797), new Point2D.Double(0.75, 7472.53874133636), };

		if (grunt instanceof GruntSpoisty) {
			switch (((GruntSpoisty) grunt).getKonsolidacja()) {
			case A:
				return lagrangeInterpolation(pomA, ws);
			case B:
				return lagrangeInterpolation(pomB, ws);
			case C:
				return lagrangeInterpolation(pomC, ws);
			case D:
				return lagrangeInterpolation(pomD, ws);
			default:
				break;
			}
		} else if (grunt instanceof Grunt) {
			switch (grunt.getGrunt()) {
			case ¯:
				return lagrangeInterpolation(pom¯Po, ws);
			case Po:
				return lagrangeInterpolation(pom¯Po, ws);
			case Pr:
				return lagrangeInterpolation(pomPrPs, ws);
			case Ps:
				return lagrangeInterpolation(pomPrPs, ws);
			case Pd:
				return lagrangeInterpolation(pomPdPpi, ws);
			case Ppi:
				return lagrangeInterpolation(pomPdPpi, ws);
			default:
				break;
			}
		}
		return -1;
	}

	/**
	 * 
	 * Interpoluje wartoœci metod¹ lagrage'a
	 * 
	 * @param points - punkty stanowi¹ce podstawê do interpolacji
	 * @param x      - x dla ktorego wyinterpolowywana jest wartoœæ
	 * @return - wyinterpolowana wartoœæ
	 */
	public static double lagrangeInterpolation(Point2D.Double[] points, double x) {
		double l = 1;
		double p = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					l *= (x - points[j].getX()) / (points[i].getX() - points[j].getX());
				}
			}
			p += (points[i].getY() * l);
			l = 1;
		}
		return p;
	}

	/**
	 * metoda do rozpoznawania stanów gruntów
	 * 
	 * @param grunt
	 * @param ws
	 * @return
	 */
	public static stany stan(grunty grunt, double ws) {
		if (grunt == grunty.¯ || grunt == grunty.Po || grunt == grunty.Pr || grunt == grunty.Ps || grunt == grunty.Pd
				|| grunt == grunty.Ppi) {
			if (ws >= 0.68) {
				return stany.zg;
			} else if (ws >= 0.33) {
				return stany.szg;
			} else if (ws < 0.33) {
				return stany.ln;
			}
		} else if (grunt == grunty.¯g || grunt == grunty.Pog || grunt == grunty.Pg || grunt == grunty.Pip
				|| grunt == grunty.Pi || grunt == grunty.Gp || grunt == grunty.G || grunt == grunty.Gpi
				|| grunt == grunty.Gpz || grunt == grunty.Gz || grunt == grunty.Gpiz || grunt == grunty.Ip
				|| grunt == grunty.I || grunt == grunty.Ipi) {
			if (ws < 0) {
				return stany.pzw;
			} else if (ws < 0.25) {
				return stany.tpl;
			} else if (ws < 0.5) {
				return stany.pl;
			} else if (ws >= 0.5) {
				return stany.mpl;
			}
		}

		return null;
	}

	public void ropzonajGline(grunty grunt) {

	}
}
