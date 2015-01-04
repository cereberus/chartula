package zad_03_swing_animation;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rotation extends JFrame implements ActionListener
{
    private JButton fast = new JButton("Start/Stop");
    private JButton slow = new JButton("Start/Stop");
    private javax.swing.Timer fastTimer = null;
    private javax.swing.Timer slowTimer = null;
    private double fastAngle = 0.0d;
    private double slowAngle = 45.0d;
    private boolean fastIsWorking = false;
    private boolean slowIsWorking = false;
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
        new Rotation();
    }
    //------------------------
    public Rotation()
    {
        super("Mikolaj Buchwald");
        setLayout(new BorderLayout(2,2));
        
        add(new PanelRysunku(),BorderLayout.CENTER);
        add(createButtonsPanel(),BorderLayout.SOUTH);
        
        fastTimer = new javax.swing.Timer(0,new Task1());
        fastTimer.setDelay(50);
        slowTimer = new javax.swing.Timer(0,new Task2());
        slowTimer.setDelay(100);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //------------------------
    private JPanel createButtonsPanel()
    {
        JPanel panel = new JPanel();
        fast.addActionListener(this);
        panel.add(fast);
        slow.addActionListener(this);
        panel.add(slow);        
        return panel;        
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        if(src == fast)
        {
            if(fastIsWorking)
            {
                fastTimer.stop();
            }
            else
            {
                fastTimer.start();
            }
            fastIsWorking = !fastIsWorking;
        }
        if(src == slow)
        {
            if(slowIsWorking)
            {
                slowTimer.stop();
            }
            else
            {
                slowTimer.start();
            }
            slowIsWorking = !slowIsWorking;
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
            g.setColor(Color.RED);
            double angle = Math.toRadians(fastAngle);
            int x = (int)(250*Math.cos(angle));
            int y = (int)(250*Math.sin(angle));
            g.drawLine(300,300,300 + x,300 + y);
            g.setColor(Color.BLUE);
            angle = Math.toRadians(slowAngle);
            x = (int)(150*Math.cos(angle));
            y = (int)(150*Math.sin(angle));
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
    class Task1 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            fastAngle++;
            repaint();
        }
    }
    //------------------------
    class Task2 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            slowAngle++;
            repaint();
        }
    }    
}

