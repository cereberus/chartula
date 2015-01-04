package zad_03_swing_animation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Zegar_v2 extends JFrame implements ActionListener
{
	private String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	private javax.swing.Timer seconds = null;
    private javax.swing.Timer minutes = null;
    private javax.swing.Timer hours = null;
    private javax.swing.Timer date = null;
    private double sAngle = -90.0d;
    private double mAngle = -90.0d;
    private double hAngle = -90.0d;
    private Color color = new Color(63,63,65);
    private Color scolor = new Color(130,130,130);
    private Color mcolor = new Color(163,168,57);
    private Color hcolor = new Color(41,217,194);
    private JTextField tf_width = new JTextField(timeStamp);    
    private JTextField calendar = new JTextField(2);
	private JTextField time = new JTextField(2); 
//    private SimpleDateFormat df=new SimpleDateFormat("EEEEEEEEEEEE dd.MM.yyyy HH:mm:ss"); 

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
        new Zegar_v2();
    }
    //------------------------
    public Zegar_v2()
    {
        super("Magdalena Witczak");
        setLayout(new BorderLayout(2,2));
          
        add(createToolBar1(),BorderLayout.NORTH);
        add(new PanelRysunku(),BorderLayout.CENTER); 
        add(createToolBar2(),BorderLayout.SOUTH);
        
        seconds = new javax.swing.Timer(1000,new Task1());
        minutes = new javax.swing.Timer(60000,new Task2());
        hours = new javax.swing.Timer(3600000,new Task3());
        date = new javax.swing.Timer(1000,new Task4());
        
        seconds.start();
        minutes.start();
        hours.start();
        date.start();
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
	//------------------------
    public void actionPerformed(ActionEvent ae)
    {
    	
    }
    
    //------------------------
    private JToolBar createToolBar1()
    {
        JToolBar tb = new JToolBar();
        
        
        GregorianCalendar date=new GregorianCalendar();
//        String time =df.format(date.getTime()); 

        
        calendar.setEditable(false);
        tb.add(calendar);
        tb.add(tf_width);
        return tb;         
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
            
            g.setColor(color);
            g.fillOval(50,50,500,500);
            
            g.setColor(scolor);
            double angle = Math.toRadians(sAngle);
            int x = (int)(250*Math.cos(angle));
            int y = (int)(250*Math.sin(angle));
            g.drawLine(300,300,300 + x,300 + y);
            
            g.setColor(mcolor);
            angle = Math.toRadians(mAngle);
            x = (int)(150*Math.cos(angle));
            y = (int)(150*Math.sin(angle));
            g.drawLine(300,300,300 + x,300 + y);  
            
            g.setColor(hcolor);
            angle = Math.toRadians(hAngle);
            x = (int)(100*Math.cos(angle));
            y = (int)(100*Math.sin(angle));
            g.drawLine(300,300,300 + x,300 + y); 
        }
        //druga wersja metody paintComponent, wykorzystywana jest metoda translate z klasy Graphics2D         
        /*public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(300,300);            
            g2.setColor(Color.RED);
            double angle = Math.toRadians(fastAngle);
            int x = (int)(250*Math.cos(angle));
            int y = (int)(250*Math.sin(angle));
            g2.drawLine(0,0,x,y);
            g2.setColor(Color.BLUE);
            angle = Math.toRadians(slowAngle);
            x = (int)(150*Math.cos(angle));
            y = (int)(150*Math.sin(angle));
            g2.drawLine(0,0,x,y);            
        }*/        
    }
    
    
   
  //------------------------
    private JToolBar createToolBar2()
    {
        JToolBar tb = new JToolBar();
        
        time.setEditable(false);
        tb.add(time);
        return tb;         
    }
    
    //------------------------
    class Task1 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            sAngle++;
            repaint();
        }
    }
    //------------------------
    class Task2 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            mAngle++;
            repaint();
        }
    }    
  //------------------------
    class Task3 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            hAngle++;
            repaint();
        }
    }
  //------------------------
    class Task4 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
        	timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            tf_width = new JTextField(timeStamp);
//            tf_width.updateUI();
            System.out.println(timeStamp );
//            repaint();
        }
    }
  //------------------------    
    
}
