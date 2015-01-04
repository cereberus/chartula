package zad_02_swing_paint_paski;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rectangles extends JFrame implements ActionListener
{
    private JTextField tf_width = new JTextField("1  ");
    private JTextField tf_sample = new JTextField(2);
    private JButton chooseColor = new JButton("Wyb�r koloru");
    private JButton paintRectangle = new JButton("Dorysowanie prostok�ta");
    private JButton clear = new JButton("Wymazanie wszystkiego");
    private ArrayList<ColoredRectangle> rectangles = new ArrayList<ColoredRectangle>();
    private Color color = new Color(0,146,0);
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
        super("Rysowanie prostokat�w");
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
        tb.add(new JLabel("Szeroko�� kreski: "));
        tb.add(tf_width);
        chooseColor.addActionListener(this);
        tb.addSeparator();
        tb.add(chooseColor);
        tb.addSeparator();
        tf_sample.setEditable(false);
        tf_sample.setBackground(color);
        tb.add(tf_sample);
        return tb;         
    }
    //------------------------
    private JPanel createButtonsPanel()
    {
        JPanel bottom = new JPanel();
        paintRectangle.addActionListener(this);
        bottom.add(paintRectangle);
        clear.addActionListener(this);
        bottom.add(clear);
        return bottom;        
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        if(src == chooseColor)
        {            
            Color color = JColorChooser.showDialog(this,"Kolor wielok�ta",this.color);
            if(color != null)
            {
                tf_sample.setBackground(color);
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
            int x = r.nextInt(801);
            int y = r.nextInt(601);
            int width = r.nextInt(801-x);
            int height = r.nextInt(601-y);
            rectangles.add(new ColoredRectangle(x,y,width,height,color,Integer.parseInt(tf_width.getText().trim())));
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
            for(ColoredRectangle r:rectangles)
            {
                g2.setColor(r.color);
                g2.setStroke(new BasicStroke(r.stroke)); 
                g2.fillRect(r.x,r.y,r.width,r.height);
                g2.setColor(Color.BLACK);
                g2.drawRect(r.x,r.y,r.width,r.height);
            }        
        }        
    }
}

