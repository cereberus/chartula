package zad_03_swing_animation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
  
public class Around extends JFrame implements ActionListener
{
    private int deltaX = 1;
    private JButton thereAndBack = new JButton("Start/Stop");
    private JButton growing = new JButton("Wyd�u�enie");
    private int x = 0;
    private int y = 0;
    private int width = 25;
    private int init_width = 25;
	private Color color = new Color(255,211,0);
    private final int MOVING = 1;
    private final int GROWING = 2;
    private int status = MOVING;
    private Timer timer = null;
    private int count_time = 0;

    private int stan = 1;
	//------------------------
    public static void main(String[] args) 
    {
        new Around();
    }
	//------------------------
	public Around()
	{
        super("Mikolaj Buchwald");
        setLayout(new BorderLayout(2,2));
 
        add(new PanelRysowania(),BorderLayout.CENTER);
        JPanel panel = new JPanel();
        thereAndBack.addActionListener(this);
        panel.add(thereAndBack);
        add(panel,BorderLayout.SOUTH);         
 
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        timer = new javax.swing.Timer(9,new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
            	
            	count_time += 1;
            	System.out.println("Miliseconds that has passed: " + count_time);
            	switch(stan)
            	{
            	case 1:
            		width++;
            		if(width == init_width*6)
            		{
            			stan = 2;
            		}
            		break;
            	case 2:
            		x++;
            		if(x == 450)
            		{
            		    stan = 3;
            		}
            		break;
             	case 3:
            		y++;
            		if(y == 450)
            		{
            		    stan = 4;
            		}
            		break;  
             	case 4:
            		x--;
            		if(x == 0)
            		{
            		    stan = 5;
            		}
            		break;
             	case 5:
            		y--;
            		if(y == 0)
            		{
            		    stan = 6;
            		}
            		break;
             	case 6:
             		width--;
            		if(width == init_width) //TODO change this
            		{
            			stan = 7;
            		}
            		break;
              	case 7:
             		timer.stop();
             		stan = 1;
            		break;
            	}
            	repaint();

            }
        });        
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        if(timer.isRunning())
        {
        	timer.stop();
        }
        else
        {
        	//x = 0;
        	//y = 0;
        	//width = 25;
        	timer.start();
        }
    }
    //------------------------
    class PanelRysowania extends JPanel 
    {
        public PanelRysowania() 
        {
            setPreferredSize(new Dimension(601,601));
            setBackground(Color.WHITE);
        }
		//--------------------
        public void paintComponent(Graphics g) 
        {
		    super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x,y,width,width);
            g.setColor(Color.BLACK);
            g.drawRect(x,y,width,width);
        }
    }	
}

 
 
 
