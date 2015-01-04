package zad_04_swing_malarz;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.text.SimpleDateFormat;

//deklaracje importu
 
public class Malarz_old extends JFrame implements ActionListener
{
    //definicje p�l (sk�adowych klasy)
    private BufferedImage img = null;  
    private int width;
    private int height;
    //------------------------
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
        new Malarz_old();
    }
    //------------------------
    public Malarz_old()
    {
        setTitle("Kubu� Puchatek");
        setLayout(new BorderLayout(2,2));
               
        add(createToolBar(),BorderLayout.NORTH);
        
        panel = new PanelRysowania();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panel,BorderLayout.CENTER);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);        
    }
    //------------------------
    private JToolBar createToolBar()
    {
        JToolBar tb = new JToolBar();        
        //umieszczenie komponent�w na pasku narz�dzi JToolBar
        return tb;
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        //obs�uga klikni�cia w przycisk
        //zak�adam, �e obiekt JFileChooser nazywa si� fc, a przycisk otwierania pliku open
        if(src == open)
        {
            //...
            img = ImageIO.read(fc.getSelectedFile());
            //...
        }        
    }
    //------------------------
    class PanelRysowania extends JPanel
    {
        public PanelRysowania()
        {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dim.width-=100;
            dim.height-=160;
            width = dim.width;
            height = dim.height;
            setPreferredSize(dim);
            setBackground(Color.WHITE);
        }
        //-------------------
        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            //malowanie
        } 
    }
}