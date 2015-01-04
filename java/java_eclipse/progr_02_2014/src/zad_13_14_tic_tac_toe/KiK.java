package zad_13_14_tic_tac_toe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class KiK extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfkomp = new JTextField("0",2);
	private JTextField tfczlo = new JTextField("0",2);
	private JTextField komunikat = new JTextField("",10);
	private JButton zeruj = new JButton("Zeruj");
	
	
	private JRadioButton o = new JRadioButton("Kolko", true);
    private JRadioButton x = new JRadioButton("Krzyzyk", false);
    private ButtonGroup bg = new ButtonGroup();
    private JButton start = new JButton("Zacznij");
    
    
    private JButton tablica[][]=new JButton[3][3];
    private Random ran = new Random();
    private int losowanie = 0;
    private int gracz = 1;
    private int komp = 2;
    private boolean dobre = true;
    private boolean ox = true;
    private int zapelnienie = 0;
    private int wygranekomp = 0;
    private int wygraneczlo = 0;
    private boolean thegameison = false;
    
	public static void main(String[] args) 
	{
		try 
        {
            UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
            for(int i=0;i<info.length;i++)             
            {
                if(info[i].getName().equals("Nimbus"))
                {
                    UIManager.setLookAndFeel(info[i].getClassName());
                }
            }
        }
        catch(Exception e)
        {
        }     
        new KiK();
	}
	public KiK()
	{
		setTitle("Kolko i krzyzyk");
		setLayout(new GridLayout(3,1,2,2));
		add(createPanel());
		add(createPanel2());
		add(createPanel3());
		
		pack();
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private JPanel createPanel()
    {
		JPanel p = new JPanel();
		p.add(new JLabel("Komputer: "));
    	p.add(tfkomp);
    	tfkomp.setEditable(false);
    	p.add(new JLabel("Ty: "));
    	p.add(tfczlo);
    	tfczlo.setEditable(false);
    	p.add(zeruj);
    	zeruj.addActionListener(this);
    	p.add(komunikat);
		komunikat.setEditable(false);
    	p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Stan meczu"));
		return p;
    }
	private JPanel createPanel2()
    {
		JPanel p2 = new JPanel();
		p2.add(o);
        p2.add(x);
        o.addActionListener(this);
        x.addActionListener(this);
        
        bg.add(o);
        bg.add(x);
    	p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Menu"));
		p2.add(start);
		start.addActionListener(this);
    	return p2;
    }
	private JPanel createPanel3()
    {
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(3,3,2,2));
    	p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Plansza"));
		
    	for (int i=0;i<3;i++)
    	{
    		for (int j=0;j<3;j++)
    		{
    			JButton b = new JButton();
    			tablica[i][j] = b;
    			p3.add(b);
    			b.addActionListener(this);
    		}
    	}
    	
    	p3.setPreferredSize(new Dimension(250, 120));
    	return p3;
    }
	public void actionPerformed(ActionEvent ae) 
	{
		AbstractButton b = (AbstractButton)ae.getSource();
		
		////////////////////////START//////////////////////////////////////////
		if (b==start)
		{
			for (int i=0;i<3;i++)
	    	{
	    		for (int j=0;j<3;j++)
	    		{
	    			tablica[i][j].setText("");
	    			tablica[i][j].setEnabled(true);
	    		}
	    	}
			
			if (o.isSelected())
			{
				ox = true;
			}
			if (x.isSelected())
			{
				ox = false;
			}
			
			losowanie = ran.nextInt(2)+1;
			zapelnienie = 0;
			thegameison = true;
			komunikat.setText("Twoj ruch");
		}
		
		////////////////////////RUCH GRACZA/////////////////////////////////////
		if (thegameison)
		{
			if (losowanie==gracz && b!=start)
			{
				if (b.getText().isEmpty())
				{
					if (ox)
					{
						b.setText("O");
					}
					else
					{
						b.setText("X");
					}
					b.setEnabled(false);
					komunikat.setText("Twoj ruch");
					losowanie=komp;
					zapelnienie++;
				}
			}
		}
		///////////////////////////////////////////////////////////////////////
		sprawdzenie();
		///////////////////////RUCH KOMPUTERA//////////////////////////////////
		ruchkomputera();
		////////////////////ZEROWANIE//////////////////////////////////
		if (b==zeruj)
		{
			tfkomp.setText("0");
			tfczlo.setText("0");
			wygraneczlo=0;
			wygranekomp=0;
		}
		////////////////////////////////////////////////////////////////
		
		sprawdzenie();
	}
	
	public void sprawdzenie()
	{
		if (zapelnienie >4)
		{
			
			
			if (thegameison)
			{
				if (!ox) 
				{
					if((tablica[0][0].getText().equals(tablica[0][1].getText())) && (tablica[0][1].getText().equals(tablica[0][2].getText())))
						{
							if (tablica[0][0].getText().equals("O"))
							{
								komunikat.setText("Wygral komputer");
								wygranekomp++;
								tfkomp.setText(""+wygranekomp);
								thegameison =false;
							}
							if (tablica[0][0].getText().equals("X"))
							{
								komunikat.setText("Zwyciestwo!");
								wygraneczlo++;
								tfczlo.setText(""+wygraneczlo);
								thegameison =false;
							}
							
						}
					if((tablica[1][0].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[1][2].getText())))
					{
						if (tablica[1][0].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[1][0].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
						
					}
					if((tablica[2][0].getText().equals(tablica[2][1].getText())) && (tablica[2][1].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[2][0].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[2][0].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][0].getText().equals(tablica[1][0].getText())) && (tablica[1][0].getText().equals(tablica[2][0].getText())))
					{
						if (tablica[0][0].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][0].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					
					if((tablica[0][1].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][1].getText())))
					{
						if (tablica[0][1].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][1].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][2].getText().equals(tablica[1][2].getText())) && (tablica[1][2].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[0][2].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][2].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					
					if((tablica[0][0].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[0][0].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][0].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][2].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][0].getText())))
					{
						if (tablica[0][2].getText().equals("O"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][2].getText().equals("X"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
				}     
				
				if (ox) 
				{
					if((tablica[0][0].getText().equals(tablica[0][1].getText())) && (tablica[0][1].getText().equals(tablica[0][2].getText())))
						{
							if (tablica[0][0].getText().equals("X"))
							{
								komunikat.setText("Wygral komputer");
								wygranekomp++;
								tfkomp.setText(""+wygranekomp);
								thegameison =false;
							}
							if (tablica[0][0].getText().equals("O"))
							{
								komunikat.setText("Zwyciestwo!");
								wygraneczlo++;
								tfczlo.setText(""+wygraneczlo);
								thegameison =false;
							}
						}
					if((tablica[1]
[0].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[1][2].getText())))
					{
						if (tablica[1][0].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[1][0].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
						
					}
					if((tablica[2][0].getText().equals(tablica[2][1].getText())) && (tablica[2][1].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[2][0].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[2][0].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][0].getText().equals(tablica[1][0].getText())) && (tablica[1][0].getText().equals(tablica[2][0].getText())))
					{
						if (tablica[0][0].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][0].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					
					if((tablica[0][1].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][1].getText())))
					{
						if (tablica[0][1].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][1].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][2].getText().equals(tablica[1][2].getText())) && (tablica[1][2].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[0][2].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][2].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					
					if((tablica[0][0].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][2].getText())))
					{
						if (tablica[0][0].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][0].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					if((tablica[0][2].getText().equals(tablica[1][1].getText())) && (tablica[1][1].getText().equals(tablica[2][0].getText())))
					{
						if (tablica[0][2].getText().equals("X"))
						{
							komunikat.setText("Wygral komputer");
							wygranekomp++;
							tfkomp.setText(""+wygranekomp);
							thegameison =false;
						}
						if (tablica[0][2].getText().equals("O"))
						{
							komunikat.setText("Zwyciestwo!");
							wygraneczlo++;
							tfczlo.setText(""+wygraneczlo);
							thegameison =false;
						}
					}
					
				}
			
			
			}
		}
		if (thegameison)
		{
			if (zapelnienie ==9)
			{
				komunikat.setText("Remis!");
				thegameison =false;
			}
		}
	}
	public void ruchkomputera()
	{
		if (thegameison)
		{
			if (losowanie==komp)
					{
						while(dobre)
						{
							int ruch1 = ran.nextInt(3);
							int ruch2 = ran.nextInt(3);
							
							if (tablica[ruch1][ruch2].getText().isEmpty())
							{
								if (!ox)
								{
									tablica[ruch1][ruch2].setText("O");
									tablica[ruch1][ruch2].setEnabled(false);
								}
								if (ox)
								{
									tablica[ruch1][ruch2].setText("X");
									tablica[ruch1][ruch2].setEnabled(false);
								}
								break;
							}
						}
					}
					
					losowanie=gracz;
					zapelnienie++;
			
			
		}}
}