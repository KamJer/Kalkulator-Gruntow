package komponenty.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import komponenty.Grunt;
import komponenty.GruntSpoisty;
import komponenty.Obliczenia;
import komponenty.Obliczenia.grunty;
import komponenty.Obliczenia.konsGrupa;
import komponenty.Obliczenia.wilgotnosc;
import komponenty.Writer;

public class MainFrame extends JFrame {

	private static final int X_SIZE = 350;
	private static final int Y_SIZE = 500;
	
//	jakie to jest kurwa chujowe, przysz³y kamilu napraw to
	private static final grunty[] grunt = {
		grunty.Pd, grunty.Ppi, grunty.Ps, grunty.Pr, grunty.¯, grunty.Po, grunty.Ph,
		
		grunty.¯g, grunty.Pog, grunty.Pg, grunty.Ppi, grunty.Pi, grunty.Gp, grunty.G, grunty.Gpi, grunty.Gpz, grunty.Gz, grunty.Gpiz, grunty.Ip, grunty.I, grunty.Ipi
	};
	
	private static final konsGrupa[] konsystencja = {
			konsGrupa.A, konsGrupa.B, konsGrupa.C, konsGrupa.D
	};
	
	private static final wilgotnosc[] wilg = {
		wilgotnosc.mw, wilgotnosc.w, wilgotnosc.m
	};
	
	private static final int LABELS_AND_FIELDS = 4;

	private JLabel[] labels = new JLabel[LABELS_AND_FIELDS];
	private String[] lablesNames = new String[LABELS_AND_FIELDS];

	private JTextField[] fields = new JTextField[LABELS_AND_FIELDS];

	private JButton[] operationButtons = new JButton[2];
	private String[] buttonsNames = new String[2];

	private int operationButtonsLocX = (X_SIZE / 4);
	private int operationButtonsLocY = (Y_SIZE / 7);
	
	private String[] gruntWlasc = new String[4];

	public MainFrame(String title) {
		super(title);
		setSize(X_SIZE, Y_SIZE);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		lablesNames[0] = "Grunt";
		lablesNames[1] = "Grupa kons.";
		lablesNames[2] = "wilgotnoœæ";
		lablesNames[3] = "wspó³czynnik";

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(lablesNames[i]);
			labels[i].setSize(100, 25);
			;
			labels[i].setLocation(operationButtonsLocX * 1, operationButtonsLocY * (1 + i));
			add(labels[i]);
		}

		for (int i = 0; i < fields.length; i++) {
			fields[i] = new JTextField();
			fields[i].setSize(100, 25);
			fields[i].setLocation(operationButtonsLocX * 2, operationButtonsLocY * (1 + i));
			add(fields[i]);
		}

		buttonsNames[0] = "oblicz";
		buttonsNames[1] = "anuluj";
		for (int i = 0; i < operationButtons.length; i++) {
			operationButtons[i] = new JButton(buttonsNames[i]);
			operationButtons[i].setSize(75, 25);
			operationButtons[i].setLocation(operationButtonsLocX * (i + 1), operationButtonsLocY * 6);
			add(operationButtons[i]);
		}

		operationButtons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < gruntWlasc.length; i++) {
					gruntWlasc[i] = fields[i].getText();
				}
				oblicz();
			}
		});

		operationButtons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
	}

	public void oblicz() {
		String[] gruntWasc = this.getGruntWlasc();

		grunty grun = null;
		konsGrupa kons = null;
		wilgotnosc wilg = null;
		double ws = -1;
		
		for (int i = 0; i < grunt.length; i++) {
			if (grunt[i].compere(gruntWasc[0])) {
				grun = grunt[i];
				for (int j = 0; j < konsystencja.length; j++) {
					if (konsystencja[j].compere(gruntWasc[1])) {
						kons = konsystencja[j];
						break;
					}
				}
				for (int j = 0; j < MainFrame.wilg.length; j++) {
					if (MainFrame.wilg[j].compere(gruntWasc[2])) {
						wilg = MainFrame.wilg[j];
						break;
					}
				}
				wilg = wilgotnosc.w;
				ws = Double.parseDouble(gruntWasc[3]);
				break;
			}
		}
		
		Grunt grunt = null;
		
		if (grun == grunty.¯ || grun == grunty.Po || grun == grunty.Pr || grun == grunty.Ps || grun == grunty.Pd
				|| grun == grunty.Ppi) {
			grunt = new Grunt(grun, ws);
		} else {
			grunt = new GruntSpoisty(grun, kons, ws);
		}

		String wynik = "";
		double[] para = Obliczenia.parametry(grun, ws, wilg);
		wynik += String.valueOf(para[0]) + ",";
		wynik += String.valueOf(para[1]) + ",";
		wynik += String.valueOf(para[2]) + ",";
		wynik += String.valueOf(Obliczenia.angle(grunt, ws)) + ",";
		wynik += String.valueOf(Obliczenia.cu(grunt, ws)) + ",";
		wynik += String.valueOf(Math.round(Obliczenia.E0(grunt, ws) / 1000)) + ",";
		wynik += String.valueOf(Math.round(Obliczenia.M0(grunt, ws) / 1000));

		System.out.println(wynik);
		List<String> text = new ArrayList<>();
		text.add("ro,ro0,wn,ang,Cu,E0,M0");
		text.add(wynik);
		Writer.writeTable("test.csv", text);
	}

	public String[] getGruntWlasc() {
		return gruntWlasc;
	}

}
