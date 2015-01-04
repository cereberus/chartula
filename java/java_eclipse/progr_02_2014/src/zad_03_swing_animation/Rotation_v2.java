package zad_03_swing_animation;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class Rotation_v2 extends JFrame implements ActionListener {
	private JTextField topField = new JTextField("top", 20);
	private JLabel bottomLabel = new JLabel(
			"Czas działania programu w sekundach:");
	private JTextField bottomField = new JTextField("0", 5);

	private javax.swing.Timer clockTimer = null;
	private double secondsAngle = 0;
	private double minutesAngle = 0;
	private double hoursAngle = 0;

	private long startTime = System.currentTimeMillis();

	// ------------------------
	public static void main(String args[]) {
		try {
			UIManager.LookAndFeelInfo[] info = UIManager
					.getInstalledLookAndFeels();
			for (int i = 0; i < info.length; i++) {
				if (info[i].getName().equals("Nimbus")) {
					UIManager.setLookAndFeel(info[i].getClassName());
				}
			}
		} catch (Exception e) {
		}
		new Rotation_v2();
	}

	// ------------------------
	public Rotation_v2() {
		super("Mikolaj Buchwald");
		setLayout(new BorderLayout(2, 2));

		add(createButtonsPanel2(), BorderLayout.NORTH);
		add(new PanelRysunku(), BorderLayout.CENTER);
		add(createButtonsPanel(), BorderLayout.SOUTH);

		clockTimer = new javax.swing.Timer(0, new Clock());
		clockTimer.setDelay(1000);
		clockTimer.start();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ------------------------
	private JPanel createButtonsPanel2() {
		JPanel panel = new JPanel();
		panel.add(topField);

		return panel;
	}

	// ------------------------
	private JPanel createButtonsPanel() {
		JPanel panel = new JPanel();
		panel.add(bottomLabel);
		panel.add(bottomField);

		return panel;
	}

	// ------------------------
	public void actionPerformed(ActionEvent ae) {
		// JButton src = (JButton)(ae.getSource());
	}

	public void updateClock() {
		Date now = new Date();
		SimpleDateFormat time = new SimpleDateFormat(
				"EEEEEEE  d.MM.yyyy  H:m:ss");
		topField.setText(time.format(now));
	}

	public void updateBottomInfo() {

		bottomField
				.setText(String.valueOf((int) (System.currentTimeMillis() - startTime) / 1000));
	}

	// ------------------------
	class PanelRysunku extends JPanel {
		public PanelRysunku() {
			setPreferredSize(new Dimension(600, 600));
			setBackground(Color.WHITE);
		}

		// --------------------
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			updateClock();
			updateBottomInfo();

			g.setColor(new Color(200, 100, 0));
			g.fillRect(0, 0, 1000, 1000);

			g.setColor(new Color(0, 100, 200));
			g.fillOval(300 - 260, 300 - 260, 520, 520);
			g.setColor(Color.ORANGE);
			g.fillOval(300 - 3, 300 - 3, 6, 6);

			g.setColor(Color.ORANGE);
			int x = (int) (230 * Math.cos(secondsAngle));
			int y = (int) (230 * Math.sin(secondsAngle));
			g.drawLine(300, 300, 300 + x, 300 + y);

			x = (int) (150 * Math.cos(minutesAngle));
			y = (int) (150 * Math.sin(minutesAngle));
			g.drawLine(300, 300, 300 + x, 300 + y);

			x = (int) (100 * Math.cos(hoursAngle));
			y = (int) (100 * Math.sin(hoursAngle));
			g.drawLine(300, 300, 300 + x, 300 + y);

		}
	}

	class Clock implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Date now = new Date();

			secondsAngle = Math.toRadians(360 * now.getSeconds() / 60)
					- Math.PI / 2;

			minutesAngle = Math
					.toRadians(360 * ((double) now.getMinutes() / 60 + (double) now
							.getSeconds() / 3600))
					- Math.PI / 2;
			hoursAngle = Math.toRadians(360 * ((double) now.getHours() / 12
					+ (double) now.getMinutes() / (12 * 60) + (double) now
					.getSeconds() / (12 * 60 * 60)))
					- Math.PI / 2;
			;

			repaint();
		}
	}

}
