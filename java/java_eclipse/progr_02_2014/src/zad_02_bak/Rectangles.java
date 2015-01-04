package zad_02_bak;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Rectangles extends JFrame implements ActionListener
{
    private JTextField tf_width = new JTextField("1  ");
    private JTextField tf_sample = new JTextField(2);
    private JTextField tf_sample_2 = new JTextField(2);
    private JButton chooseColor_left = new JButton("Kolor lewy");
    private JButton chooseColor_right = new JButton("Kolor prawy");
    private JButton paintRectangle = new JButton("Nowy rysunek");
    private JButton clear = new JButton("Wymazanie wszystkiego");
    private ArrayList<ColoredRectangle> rectangles = new ArrayList<ColoredRectangle>();
    private Color color = new Color(0,146,0);
    
    
    private int[] widths = new int[30];
   
    
    
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
        new Rectangles();
    }
    //------------------------
    public Rectangles()
    {
        super("Mikolaj Buchwald");
        setLayout(new BorderLayout(2,2));
        
        add(createToolBar(),BorderLayout.NORTH);
        add(new PanelRysunku(),BorderLayout.CENTER);
        add(createButtonsPanel(),BorderLayout.SOUTH);
        
        losuj(); //przed visable truth

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void losuj()
    {
    	for(int i=0;i<widths.length;i++)
    	{
    		widths[i] = r.nextInt(501)+50;
    	}
    }
    //------------------------
    private JToolBar createToolBar()
    {
        JToolBar tb = new JToolBar();
//        tb.add(tf_width);
        chooseColor_left.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColor_left);
        tb.addSeparator();
        tf_sample.setEditable(false);
        tf_sample.setBackground(color);
        
        tb.add(tf_sample);
        chooseColor_right.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColor_right);
        tb.addSeparator();
        
        tf_sample_2.setEditable(false);
        tf_sample_2.setBackground(color);
        
        tb.add(tf_sample_2);
        return tb;         
    }
    //------------------------
    private JPanel createButtonsPanel()
    {
        JPanel bottom = new JPanel();
        paintRectangle.addActionListener(this);
        bottom.add(paintRectangle);
//        clear.addActionListener(this);
//        bottom.add(clear);
        return bottom;        
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        if(src == chooseColor_left)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielok�ta",this.color);
            if(color != null)
            {
                tf_sample.setBackground(color);
                this.color = color;
            }
            return;
        }
        
        if(src == chooseColor_right)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielok�ta",this.color);
            if(color != null)
            {
                tf_sample_2.setBackground(color);
                this.color = color;
            }
            return;
        }
        if(src == clear)
        {
            rectangles.clear();
            repaint();
            return;
        }
        if(src == paintRectangle)
        {
            /*int x = r.nextInt(801);
            int y = r.nextInt(601);
            int width = 50 + (int)(Math.random() * ((550 - 50) + 1));
//            int width_2 = 50 + (int)(Math.random() * ((550 - 50) + 1));
            int height = 10;
            rectangles.add(new ColoredRectangle(x,y,width,height,color,Integer.parseInt(tf_width.getText().trim()))); */
        	
        	losuj();
            repaint();
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
            g2.setColor(Color.BLUE);
            
            
            
            int y = 5;
            
            for(ColoredRectangle r:rectangles)
            {
            	
            	
                g2.setColor(r.color);
                g2.setStroke(new BasicStroke(r.stroke)); 
                g2.fillRect(25,y,r.width,10);
                g2.setColor(Color.BLUE);
                g2.drawRect(r.x,r.y,r.width,10);

                y+=20;
            }        
        }        
    }
}
