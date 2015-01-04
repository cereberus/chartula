package zad_07_08_applets_calc;

import java.awt.*;
import java.awt.event.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;


public class Calculator extends JApplet implements ActionListener {

	private JTextField tf_x = new JTextField(12);
	private JTextField tf_y = new JTextField(12);
	private JTextField value = new JTextField(12);
	private JTextField tf_xplusy = new JTextField(12);
	private JTextField tf_xminusy = new JTextField(12);
	private JTextField tf_xrazyy = new JTextField(12);
	private JTextField tf_xprzezy = new JTextField(12);
	private JTextField tf_xmoduloy = new JTextField(12);

	private JTextField tf_a = new JTextField(12);
	private JTextField tf_b = new JTextField(12);
	private JTextField tf_c = new JTextField(12);
	private JTextField tf_pole = new JTextField(12);

	private JTextField tf_argument = new JTextField(12);
	private JTextField tf_wyrazenie = new JTextField(12);

	private JButton suma1 = (new JButton("="));
	private JButton pole3 = (new JButton("="));
	private JButton free4 = (new JButton("="));

	private double s;
	private double area;

	private ScriptEngineManager manager = new ScriptEngineManager();
	private ScriptEngine engine = manager.getEngineByName("javascript");
	
	
	
	public void init() {
		setLayout(new GridLayout(4, 1, 3, 3)); // manager rozkladu

		JPanel p1 = new JPanel();
		p1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.RED, 2),
				"Argumenty działań"));

		p1.add(new JLabel("x = "));
		p1.add(tf_x);
		tf_x.addActionListener(this);

		p1.add(new JLabel("y = "));
		p1.add(tf_y);
		tf_y.addActionListener(this);

		p1.add(suma1);
		suma1.addActionListener(this);

//		p1.add(value);
//		value.addActionListener(this);
//		value.setEditable(false);

		// ///////////////////////////////////////////////////////

		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.RED, 2), "Wyniki działań"));
		p2.add(new JLabel("x + y = "));
		p2.add(tf_xplusy);
		tf_xplusy.setEditable(false);
		tf_xplusy.addActionListener(this);

		p2.add(new JLabel("x - y = "));
		p2.add(tf_xminusy);
		tf_xminusy.setEditable(false);
		tf_xminusy.addActionListener(this);

		p2.add(new JLabel("x * y = "));
		p2.add(tf_xrazyy);
		tf_xrazyy.setEditable(false);
		tf_xrazyy.addActionListener(this);

		p2.add(new JLabel("x / y = "));
		p2.add(tf_xprzezy);
		tf_xprzezy.setEditable(false);
		tf_xprzezy.addActionListener(this);

		p2.add(new JLabel("x % y = "));
		p2.add(tf_xmoduloy);
		tf_xmoduloy.setEditable(false);
		tf_xmoduloy.addActionListener(this);

		// /////////////////////////////////////////////////////////

		JPanel p3 = new JPanel();
		p3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.RED, 2), "Pole trójkąta"));

		p3.add(new JLabel("a = "));
		p3.add(tf_a);
		tf_a.addActionListener(this);

		p3.add(new JLabel("b = "));
		p3.add(tf_b);
		tf_b.addActionListener(this);

		p3.add(new JLabel("c = "));
		p3.add(tf_c);
		tf_c.addActionListener(this);

		p3.add(pole3);
		pole3.addActionListener(this);

		p3.add(new JLabel("Pole = "));
		p3.add(tf_pole);
		tf_pole.addActionListener(this);
		tf_pole.setEditable(false);

		// ///////////////////////////////////////////////////////

		JPanel p4 = new JPanel();
		p4.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.RED, 2),
				"Dowolne wyrażenie"));

		p4.add(new JLabel("Wyrażenie = "));
		p4.add(tf_argument);
		tf_argument.addActionListener(this);

		p4.add(free4);
		free4.addActionListener(this);

		p4.add(tf_wyrazenie);
		tf_wyrazenie.addActionListener(this);

		// ///////////////////////////////////////////////////////

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		// add(createPanel1());
		// add(createPanel2());
		// add(createPanel3());
		// add(createPanel4());

	}

	// private JPanel createPanel1(){
	// JPanel p = new JPanel();
	// p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,
	// 2),"Argumenty działań"));
	//
	// p.add(new JLabel("x = "));
	// p.add(tf_x);
	// tf_x.addActionListener(this);
	//
	// p.add(new JLabel("y = "));
	// p.add(tf_y);
	// tf_y.addActionListener(this);
	//
	// // JButton b = new JButton("=");
	// // b.addActionListener(this);
	// // add(b);
	//
	// p.add(new JLabel("x + y = "));
	// value.addActionListener(this);
	// p.add(value);
	// value.setEditable(false);
	// return p;
	// }
	//
	// private JPanel createPanel2(){
	// JPanel p = new JPanel();
	// p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,
	// 2),"Wyniki działań"));
	// p.add(new JLabel("x + y = "));
	// p.add(tf_xplusy);
	// tf_xplusy.setEditable(false);
	// tf_xplusy.addActionListener(this);
	//
	// p.add(new JLabel("x - y = "));
	// p.add(tf_xminusy);
	// tf_xminusy.setEditable(false);
	// tf_xminusy.addActionListener(this);
	//
	// p.add(new JLabel("x * y = "));
	// p.add(tf_xrazyy);
	// tf_xrazyy.setEditable(false);
	// tf_xrazyy.addActionListener(this);
	//
	// p.add(new JLabel("x / y = "));
	// p.add(tf_xprzezy);
	// tf_xprzezy.setEditable(false);
	// tf_xprzezy.addActionListener(this);
	//
	// p.add(new JLabel("x % y = "));
	// p.add(tf_xmoduloy);
	// tf_xmoduloy.setEditable(false);
	// tf_xmoduloy.addActionListener(this);
	//
	// return p;
	// }
	//
	//
	// private JPanel createPanel3(){
	// JPanel p = new JPanel();
	// p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,
	// 2),"Pole trójkąta"));
	//
	// p.add(new JLabel("a = "));
	// p.add(tf_a);
	// tf_a.addActionListener(this);
	//
	// p.add(new JLabel("b = "));
	// p.add(tf_b);
	// tf_b.addActionListener(this);
	//
	// p.add(new JLabel("c = "));
	// p.add(tf_c);
	// tf_c.addActionListener(this);
	//
	// p.add(new JLabel("Pole = "));
	// p.add(tf_pole);
	// tf_pole.addActionListener(this);
	// return p;
	// }
	//
	// private JPanel createPanel4(){
	// JPanel p = new JPanel();
	// p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,
	// 2),"Dowolne wyrażenie"));
	// p.add(new JLabel("Wyrażenie = "));
	// p.add(tf_argument);
	// tf_argument.addActionListener(this);
	// p.add(new JLabel(" = "));
	// p.add(tf_wyrazenie);
	// tf_wyrazenie.addActionListener(this);
	// return p;
	// }

	// ------------------------
	@override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == suma1) {
			long suma = Integer.parseInt(tf_x.getText());
			suma += Integer.parseInt(tf_y.getText());
			tf_xplusy.setText("" + suma);

			long roznica = Integer.parseInt(tf_x.getText());
			roznica -= Integer.parseInt(tf_y.getText());
			tf_xminusy.setText("" + roznica);
			
			long iloczyn = Integer.parseInt(tf_x.getText());
			iloczyn *= Integer.parseInt(tf_y.getText());
			tf_xrazyy.setText("" + iloczyn);			
			
			float iloraz = Integer.parseInt(tf_x.getText());
			float iloraz2 = Integer.parseInt(tf_y.getText());
			iloraz = iloraz / iloraz2;
			tf_xprzezy.setText("" + iloraz);
			
			long modulo = Integer.parseInt(tf_x.getText());
			modulo %= Integer.parseInt(tf_y.getText());
			tf_xmoduloy.setText("" + modulo);
			
		}

		if (ae.getSource() == pole3) {
			long a = Integer.parseInt(tf_a.getText());
			long b = Integer.parseInt(tf_b.getText());
			long c = Integer.parseInt(tf_c.getText());
			s = 0.5 * (a + b + c);
			area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			tf_pole.setText("" + area);

		}

		if (ae.getSource() == free4) {
			
			String wyrazenie =  (tf_argument.getText());

//			Object wynik = null;
			
			Object wynik;
			try {
				wynik = engine.eval(wyrazenie);
				System.out.println(wyrazenie);
				tf_wyrazenie.setText("" + wynik);
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
}