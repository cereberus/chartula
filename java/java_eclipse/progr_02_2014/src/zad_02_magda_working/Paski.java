package zad_02_magda_working;



import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Paski extends JFrame implements ActionListener
{
    
	private JTextField tf_sample1 = new JTextField(2);
	private JTextField tf_sample2 = new JTextField(2);
    private JButton chooseColorl = new JButton("Kolor lewy");
    private JButton chooseColorp = new JButton("Kolor prawy");
    private JButton paintRectangle = new JButton("Nowy rysunek");
    private ArrayList<ColoredRectangle> rectangles = new ArrayList<ColoredRectangle>();
    private Color colorl = new Color(132,24,57);
    private Color colorp = new Color(195,176,145);
    private Random r = new Random();  
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
        super("Magdalena Witczak");
        setLayout(new BorderLayout(2,2));
        
        add(createToolBar(),BorderLayout.NORTH);
        add(new PanelRysunku(),BorderLayout.CENTER);
        add(createButtonsPanel(),BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
   
   
  //------------------------
    private JToolBar createToolBar()
    {
        JToolBar tb = new JToolBar();
        
        chooseColorl.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColorl);
        tf_sample1.setEditable(false);
        tf_sample1.setBackground(colorl);
        tb.add(tf_sample1);
        tb.addSeparator();
        chooseColorp.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColorp);
        tf_sample2.setEditable(false);
        tf_sample2.setBackground(colorp);
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
        if(src == chooseColorp)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielokąta",this.colorp);
            if(color != null)
            {
                tf_sample2.setBackground(color);
                this.colorp = color;
            }
            return;
        }
        if(src == chooseColorl)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielokąta",this.colorl);
            if(color != null)
            {
                tf_sample1.setBackground(color);
                this.colorl = color;
            }
            return;
        }
        if(src == paintRectangle)
        {
        	rectangles.clear();
            repaint();
            int x = r.nextInt(801);
            int y = r.nextInt(601);
            
            
        	for (int i=0;i<30;i++)  
            {
	            int height = 10;
	            int width = r.nextInt(501)+50; 
	            rectangles.add(new ColoredRectangle(x,y,width,height,colorp,1));
	            	            
            }
        	
            return;
        }
    }
    //------------------------
    class PanelRysunku extends JPanel
    {
        public PanelRysunku()
        {
            setPreferredSize(new Dimension(800,600));
            setBackground(Color.WHITE);
        }
        //--------------------
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            
            g2.drawLine(20, 5, 20, 595);
            int y=5;
            
            for(ColoredRectangle r:rectangles)
            {
            	  
                g2.setColor(colorp);
                g2.setStroke(new BasicStroke(r.stroke)); 
                g2.fillRect(21,y,r.width,10);
                g2.setColor(Color.BLACK);
                g2.drawRect(21,y,r.width,10);
                
                g2.setColor(colorl);
                g2.fillRect(21,y,r.width/2,10);
                g2.setColor(Color.BLACK);
                g2.drawRect(21,y,r.width,10);
            	
            	y+=20;
            }        
        }       
    }
}

