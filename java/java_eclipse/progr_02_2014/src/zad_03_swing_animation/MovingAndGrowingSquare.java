package zad_03_swing_animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class MovingAndGrowingSquare extends JFrame implements ActionListener
{
    private int deltaX = 1;
    private JButton thereAndBack = new JButton("Tam i z powrotem");
    private JButton growing = new JButton("Wyd�u�enie");
    private int x = 0;
	private Color color = new Color(255,211,0);
    private final int MOVING = 1;
    private final int GROWING = 2;
    private int status = MOVING;
    private Timer timerMoving = null;
    private Timer timerGrowing = null;
	//------------------------
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
		{
            public void run() 
            {
                new MovingAndGrowingSquare();
            }
        });
    }
	//------------------------
	public MovingAndGrowingSquare()
	{
        super("W�druj�cy/rosn�cy kwadrat");
        setLayout(new BorderLayout(2,2));
 
        add(new PanelRysowania(),BorderLayout.CENTER);
        JPanel panel = new JPanel();
        thereAndBack.addActionListener(this);
        panel.add(thereAndBack);
        growing.addActionListener(this);
        panel.add(growing);
        add(panel,BorderLayout.SOUTH);         
 
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        repaint();
        x = 0;
        if(src == thereAndBack)
        {
            status = MOVING;
            timerMoving = new javax.swing.Timer(10,new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    if(x == 561)
                    {
                        deltaX*=-1;
                    }
                    if(x == -1)
                    {
                        deltaX*=-1;
                    } 
                    x+=deltaX;                    
                    repaint();
                    if(x == 0)
                    {
                        timerMoving.stop();
                    }
                }
            });
            timerMoving.setInitialDelay(0);
            timerMoving.start();
            return;
        }
        if(src == growing)
        {
            status = GROWING;
            timerGrowing = new javax.swing.Timer(10,new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    x++;                    
                    repaint();
                    if(x == 561)
                    {
                        timerGrowing.stop();
                    }                    
                }
            }); 
            timerGrowing.setInitialDelay(0);
            timerGrowing.start();                       
        }
    }
    //------------------------
    class PanelRysowania extends JPanel 
    {
        public PanelRysowania() 
        {
            setPreferredSize(new Dimension(600,120));
            setBackground(Color.WHITE);
        }
		//--------------------
        public void paintComponent(Graphics g) 
        {
		    super.paintComponent(g);
            if(status == MOVING)
            {
                g.setColor(color);
                g.fillRect(x,40,40,40);
                g.setColor(Color.BLACK);
                g.drawRect(x,40,40,40);
            }
            else if(status == GROWING)
            {
                g.setColor(color);
                g.fillRect(0,40,40+x,40);
                g.setColor(Color.BLACK);
                g.drawRect(0,40,40+x,40);                
            }
        }
    }	
}

 
 
 
