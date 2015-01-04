package zad_04_swing_malarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//deklaracje importu

public class Malarz extends JFrame implements ActionListener, ChangeListener {
	// definicje pól (składowych klasy)
	private BufferedImage img = null;
	private PanelRysowania panel;

	private JFileChooser chooseFile = new JFileChooser("."); // w nawiasie
																// można nic
																// nie pisać -
																// jeśli nie
																// napiszemy
																// nic, to
																// będzie konto
																// domowe
																// użytkownika,
																// pojdyncza
																// kropka to
																// katalog
																// bieżący
	private JCheckBox cb = new JCheckBox("Czy powielac obrazek", false /*
																		 * albo
																		 * "selected"
																		 */);
	private JLabel label = new JLabel("Wsp. przezroczystosci");

	private JTextField tf_sample1 = new JTextField(4);

	private Color color1 = new Color(100, 100, 100, 255);

	private JButton open = new JButton(/*
										 * tutaj napis przycisku ("napis") albo
										 * ikonka:
										 */new ImageIcon("Open.gif"));
	private JButton colorch = null;
	private JButton play1 = null;
	private JButton play2 = null;
	private JButton showCourtain = new JButton();
	private JButton delete = new JButton();

	private boolean courtain = false;

	private JTextField tf = new JTextField("0.6 ");
	private JTextField colorInfo = new JTextField(4);
	private JButton color = new JButton();
	private JColorChooser cc = new JColorChooser();
	private Color kolor = new Color(123, 178, 205);

	private int x = 0;
	private int y = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int width = 0;
	private int height = 0;

	private float transp = 1;
	private int transp2 = 0;
	private JTextField trancoef = new JTextField("1", 2);

	private boolean point = true;

	private ArrayList<int[]> disks = new ArrayList<int[]>();
	private ArrayList<int[]> rect = new ArrayList<int[]>();

	// private AbstractButton tf;
	// ------------------------

	public static void main(String[] args) {
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
		new Malarz();
	}

	// ------------------------
	public Malarz() {
		setTitle("Mikolaj Buchwald");
		setLayout(new BorderLayout(2, 2));

		add(createToolBar(), BorderLayout.NORTH);

		panel = new PanelRysowania();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(panel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	// ------------------------
	private JToolBar createToolBar() {

		JToolBar tb = new JToolBar();
		open = new JButton(new ImageIcon("C:\\Open.gif"));
		open.addActionListener(this);
		open.setToolTipText("Wybor pliku graficznego");
		tb.add(open);
		tb.addSeparator();

		cb.addChangeListener(this);
		tb.add(cb);
		tb.addSeparator();

		// color.addActionListener(this);
		// tb.addSeparator();

		tb.add(color);
		color.setToolTipText("Wybor koloru");
		tb.add(color);
		colorInfo.setEditable(false);
		colorInfo.setBackground(kolor);
		tb.addSeparator();

		colorch = new JButton(new ImageIcon("C:\\Open.gif"));
		colorch.addActionListener(this);
		colorch.setToolTipText("C:\\Wybor koloru tla");
		tb.add(colorch);
		tb.addSeparator();

		tf_sample1.setEditable(false);
		tf_sample1.setBackground(color1);
		tb.add(tf_sample1);
		tb.addSeparator();

		tb.add(label);
		tb.addSeparator();

		tb.add(trancoef);
		tb.addSeparator();

		play1 = new JButton(new ImageIcon("C:\\Play.gif"));
		play1.addActionListener(this);
		play1.setToolTipText("Wyswietl kurtyne");
		tb.add(play1);

		play2 = new JButton(new ImageIcon("C:\\Play.gif"));
		play2.addActionListener(this);
		play2.setToolTipText("Podnies kurtyne");
		tb.add(play2);

		// umieszczenie komponentów na pasku narzędzi JToolBar
		return tb;
	}

	// ------------------------
	public void actionPerformed(ActionEvent ae) {
		JButton src = (JButton) (ae.getSource());
		// obsługa kliknięcia w przycisk
		// zakładam, że obiekt JFileChooser nazywa się fc, a przycisk
		// otwierania pliku open

		if (src == colorch) {
			Color color = JColorChooser.showDialog(this, "Kolor tla",
					this.color1);
			if (color != null) {
				tf_sample1.setBackground(color);
				this.color1 = color;
			}

		}

		if (src == play1) {
			courtain = true;
			repaint();
		}
		if (src == play2) {
			courtain = false;
			repaint();
		}

		if (src == open) {
			if (chooseFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
				;
			{
				try {
					img = ImageIO.read(chooseFile.getSelectedFile());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (src == color) {
				JColorChooser chooser = new JColorChooser();
				kolor = chooser.showDialog(this, "", kolor);
				colorInfo.setBackground(kolor);
				repaint();
			}

			repaint();
		}
		// ...

	}

	// ------------------------
	class PanelRysowania extends JPanel {

		public PanelRysowania() {
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			dim.width -= 100;
			dim.height -= 160;
			width = dim.width;
			height = dim.height;
			setPreferredSize(dim);
			setBackground(Color.WHITE);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {

					if (point) {
						x = me.getX();
						y = me.getY();
						int[] tab = new int[2];

						tab[0] = x;

//						System.out.println("x " + x);
						tab[1] = y;

//						System.out.println("y " + y);
						disks.add(tab);
					}

					if (!point) {
						int[] tab_rect = new int[4];
						tab_rect[0] = x;
						tab_rect[1] = y;
						x2 = me.getX();
						tab_rect[2] = x2;
//						System.out.println("x2 " + x2);
						y2 = me.getY();
						tab_rect[3] = y2;
//						System.out.println("y2 " + y2);
						rect.add(tab_rect);
					}

					repaint();
					point = !point;
				}
			});
		}

		// -------------------
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// malowanie

			g.setColor(Color.BLACK);
			for (int i = 0; i < disks.size(); i++) {
				int[] t = disks.get(i);
				g.fillOval(t[0] - 10/* współrzędna x */, t[1] - 10/*
																	 * współrz�
																	 * �dna y
																	 */,
						1/* średnica x */, 1/* średnica y */);
			} // związane z kółkami

			for (int i = 0; i < rect.size(); i++) {
				int[] t = rect.get(i);

				if (point) {
					g.setColor(Color.BLACK);
					if (t[0] < t[2]) {
						g.drawRect(t[0], t[1], Math.abs(t[2] - t[0]),
								Math.abs(t[3] - t[1]));
					}
					else {
						g.drawRect(t[2], t[1], Math.abs(t[0] - t[2]),
								Math.abs(t[1] - t[3]));
					}
					repaint();
				}
			}

			if (courtain) {

				try {
					transp = Float.parseFloat(trancoef.getText());
					if (transp > 1) {
						transp = 1;
						trancoef.setText("1");
					}
					if (transp < 0) {
						transp = 0;
						trancoef.setText("0");
					}

				} catch (Exception e1) {
				}
				transp2 = Math.round(transp * 255);
				Color kolor1 = new Color(color1.getRed(), color1.getGreen(),
						color1.getBlue(), transp2);
				g.setColor(kolor1);
				g.fillRect(0, 0, width, height);

				repaint();

				// double alfa = Double.parseDouble(tf.getText());
				// g.setColor(new
				// Color(kolor.getRed(),kolor.getGreen(),kolor.getBlue(),(int)(255*alfa)));
				// g.fillRect(0,0,width+20,height+20);

			}

			if (img != null) // ! to negacja, czyli != to znaczy
								// "nie jest równe", a == to znaczy "równe"
			{
				if (!cb.isSelected()) {
					// jeśli ustawiamy to set, jeśli odczytujemy to get +
					// jeśli logiczna to is
					g.drawImage(img, 0, 0, null);
				} else {
					int w = img.getWidth();
					int h = img.getHeight();
					for (int i = 0; i < width / w + 1/*
													 * szer. pola/szer.obrazka +
													 * 1
													 */; i++) {
						for (int j = 0; j < height / w + 1/*
														 * szer.
														 * pola/szer.obrazka + 1
														 */; j++) {
							g.drawImage(img, i * w, j * h, null); // powielanie
																	// w
																	// poziomie
						}

					}

				}

			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		repaint(); // odmaluj po zaznaczeniu ptaszka w checkboxie

	}
}