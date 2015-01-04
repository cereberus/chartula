package zad_02_swing_paint_kasia_t;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paski extends JFrame implements ActionListener
{
    
	private JTextField tf_sample1 = new JTextField(2);
	private JTextField tf_sample2 = new JTextField(2);
    private JButton chooseColor1 = new JButton("Kolor zwyczajny");
    private JButton chooseColor2 = new JButton("Kolor skrajny");
    private JButton paintRectangle = new JButton("Nowy rysunek");
    private ArrayList<ColoredRectangle> rectangles = new ArrayList<ColoredRectangle>();
    private Color color1 = new Color(0,146,0);
    private Color color2 = new Color(100,26,50);
    private Random r = new Random();
    int a=0;
    //------------------------
    public static void main(String args[])
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
        new Paski();
    }
    //------------------------
    public Paski()
    {
        super("Kasia Tarasiuk");
        setLayout(new BorderLayout(2,2));
        
        add(createToolBar(),BorderLayout.NORTH);
        add(new PanelRysunku(),BorderLayout.CENTER);
        add(createButtonsPanel(),BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //------------------------
    private JToolBar createToolBar()
    {
        JToolBar tb = new JToolBar();
        chooseColor1.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColor1);
        tf_sample1.setEditable(false);
        tf_sample1.setBackground(color1);
        tb.add(tf_sample1);
        tb.addSeparator();
        chooseColor2.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColor2);
        tf_sample2.setEditable(false);
        tf_sample2.setBackground(color2);
        tb.add(tf_sample2);
        return tb;         
    }
    //------------------------
    private JPanel createButtonsPanel()
    {
        JPanel bottom = new JPanel();
        paintRectangle.addActionListener(this);
        bottom.add(paintRectangle);
        return bottom;        
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        if(src == chooseColor1)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielok�ta",this.color1);
            if(color != null)
            {
                tf_sample1.setBackground(color);
                this.color1 = color;
            }
            return;
        }
        if(src == chooseColor2)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielok�ta",this.color2);
            if(color != null)
            {
                tf_sample2.setBackground(color);
                this.color2 = color;
            }
            return;
        }
        if(src == paintRectangle)
        {
        	rectangles.clear();
            repaint();
            int x;
            int[] Lista = new int[30];
            int min = 600;
            int max = 0;
            int pozycja = 0;
        	for (int i=0;i<30;i++) 
            {
            	x = 5+20*a;
	            a++;
	            int width = 10;
	            int height = r.nextInt(501)+55; 
	            Lista[pozycja] = height;
	            int y = 595-height;
	            rectangles.add(new ColoredRectangle(x,y,width,height,color1,1));
	          
	            pozycja++;
	            if (min>height)
	            {
	            	min = height;
	            }
	            if (max<height)
	            {
	            	max = height;
	            }
            }
        	a=0;
        	x=5;
        	for (int i=0;i<30;i++)
        	{
        		if (Lista[i]==max)
        		{
        			rectangles.remove(i);
        			rectangles.add(i, new ColoredRectangle((5+i*20),(595-max),10,max,color2,1));
        			repaint();
        		}
        		if (Lista[i]==min)
        		{
        			rectangles.remove(i);
        			rectangles.add(i, new ColoredRectangle((5+i*20),(595-min),10,min,color2,1));
        			repaint();
        		}
        	}
            return;
        }
    }
    //------------------------
    class PanelRysunku extends JPanel
    {
        public PanelRysunku()
        {
            setPreferredSize(new Dimension(600,600));
            setBackground(Color.WHITE);
        }
        //--------------------
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            for(ColoredRectangle r:rectangles)
            {
                g2.setColor(r.color);
                g2.setStroke(new BasicStroke(r.stroke)); 
                g2.fillRect(r.x,r.y,r.width,r.height);
                g2.setColor(Color.BLACK);
                g2.drawRect(r.x,r.y,r.width,r.height);
                g2.drawLine(0,595,600,595);
            }        
        }       
    }
}

