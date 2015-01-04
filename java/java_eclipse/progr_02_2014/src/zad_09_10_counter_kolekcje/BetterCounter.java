package zad_09_10_counter_kolekcje;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BetterCounter extends JFrame implements ActionListener {
	private JTextField tfHowMany = new JTextField(12);
	private JTextField tfMaxNumber = new JTextField(12);
	private JTextField tfMinNumber = new JTextField(12);
	private JTextField tfHowManyAll = new JTextField(12);
	private JTextField tfFileName = new JTextField(12);
	private JTextArea taText = new JTextArea();
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rosnąco = new JRadioButton("Rosnąco");
	private JRadioButton malejąco = new JRadioButton("Malejąco");
	private JButton open = new JButton(new ImageIcon("Open.gif"));
	private JFileChooser fc = new JFileChooser(".");
	private int[] nsstats;
	private int nsstatssize = 0;

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
		new BetterCounter();
	}

	// ------------------------
	public BetterCounter() {
		setTitle("Mikołaj Buchwald");
		add(createToolBar(), BorderLayout.NORTH);
		add(initComponents(), BorderLayout.CENTER);
		add(initBottomPanel(), BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// ------------------------
	private JToolBar createToolBar() {
		JToolBar tb = new JToolBar();
		open.setToolTipText("Wybierz plik");
		open.addActionListener(this);
		malejąco.addActionListener(this);
		rosnąco.addActionListener(this);
		// this this this - co to jest? ...
		tb.add(open);
		tb.add(malejąco);
		tb.add(rosnąco);
		malejąco.setSelected(true);

		buttonGroup.add(rosnąco);
		buttonGroup.add(malejąco);

		return tb;
	}

	private JPanel initBottomPanel()
	{
		JPanel p = new JPanel();
			
			taText.setEditable(false);
			taText.setColumns(50);
			taText.setRows(10);
			taText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
			JScrollPane scrollPane = new JScrollPane(taText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			p.add(scrollPane);
			
		return p;
	}
	
	// ------------------------
	private JPanel initComponents() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 2, 2, 2)); 
		Font f = new Font("Arial", Font.PLAIN, 16);

		JLabel l = new JLabel("Ilość roznych liczb: ", JLabel.RIGHT); 
		l.setFont(f);
		p.add(l);
		tfHowMany.setEnabled(false);
		p.add(tfHowMany);
		
		l = new JLabel("Ilość wszystkich liczb: ", JLabel.RIGHT);
		l.setFont(f);
		p.add(l);
		tfHowManyAll.setEnabled(false);
		p.add(tfHowManyAll);

		l = new JLabel("Największa liczba: ", JLabel.RIGHT); 
		l.setFont(f);
		p.add(l);
		tfMaxNumber.setEnabled(false);
		p.add(tfMaxNumber);

		l = new JLabel("Najmniejsza liczba: ", JLabel.RIGHT);
		l.setFont(f);
		p.add(l);
		tfMinNumber.setEnabled(false);
		p.add(tfMinNumber);

		l = new JLabel("Badany plik: ", JLabel.RIGHT);
		l.setFont(f);
		p.add(l);
		tfFileName.setEnabled(false);
		p.add(tfFileName);
		
		return p;
	}


	private String buildLine(int i, int n)
	{
		return "\t" + String.valueOf(i) + "\t\t\t" + String.valueOf(nsstats[i]) + "\n";
	}
	  
	private void fillTextArea()
	{
		if (nsstatssize > 0)
		{
			taText.setText("Wartość \t Ilość wystąpień \n");
			if (malejąco.isSelected())
			{
				for (int i=nsstatssize-1; i >= 0; i--)
				{
					if(nsstats[i]>0)
					{
						taText.append(buildLine(i,nsstats[i]));
					}
				}
			}
			if (rosnąco.isSelected())
			{
				for (int i=0; i < nsstatssize; i++)
				{
					if(nsstats[i]>0)
					{
						taText.append(buildLine(i,nsstats[i]));
					}
				}			
			}
		}
	}
	
	// ------------------------
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == malejąco || ae.getSource() == rosnąco)
		{
			fillTextArea();
			return;
		}
		
		if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
			return;
		}
		tfHowMany.setText(""); // jak wiele
		tfMaxNumber.setText(""); //najwiekszy numer
		tfMinNumber.setText(""); //najmniejszy numer
		tfFileName.setText(fc.getSelectedFile().getName());
		TreeSet<Integer> set = new TreeSet<Integer>();
	
		Scanner sc = null;
		try {
			sc = new Scanner(fc.getSelectedFile());
			int overall_count = 0;
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] numbers = line.split(";"); // ; semicolon-separated-value ;)
				
				int i = 0;
				for (i = 0; i < numbers.length; i++) {
					overall_count++;
					set.add(Integer.parseInt(numbers[i]));
				}
			}
			
			sc.close(); sc = new Scanner(fc.getSelectedFile());
			
			
			nsstatssize = set.last()+1;
			nsstats = new int[nsstatssize];
			for (int i=0; i < nsstatssize; i++)
			{
				nsstats[i]=0;
			}

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] numbers = line.split(";");
				
				int i = 0;
				for (i = 0; i < numbers.length; i++) {
					nsstats[Integer.parseInt(numbers[i])]++;
				}
			}
			fillTextArea();
			sc.close();

			tfHowMany.setText(String.valueOf(set.size()));
			tfHowManyAll.setText(String.valueOf(overall_count));
			tfMaxNumber.setText(String.valueOf(set.last()));
			tfMinNumber.setText(String.valueOf(set.first()));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
