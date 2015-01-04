package zad_07_08_applets_calc;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

public class StarPolygon extends JApplet implements ActionListener
{
    private JInputInteger tf_n=new JInputInteger(3,100,"7");
    private JInputInteger tf_k=new JInputInteger(1,100,"3");
    private JInputInteger tf_R=new JInputInteger(100,350,"350");
    private JInputInteger tf_width=new JInputInteger(1,10,"3");
    private JTextField tf_sample;
    private int n;
    private int k;
    private int R;
    private boolean paintPolygon=false;
    private double r;
    private int width;
    private ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    private JCheckBox empty = new JCheckBox("Pusty: ");
    private Color kolor = new Color(0,146,0);
    private Panel rysunek;
    //------------------------
    public void init()
    {
        JToolBar tb=new JToolBar();
        tb.setLayout(new FlowLayout(FlowLayout.CENTER));

        tb.add(new JLabel("n = "));
        tb.add(tf_n);

        tb.addSeparator();

        tb.add(new JLabel("k = "));
        tb.add(tf_k);

        tb.addSeparator();

        tb.add(new JLabel("R = "));
        tb.add(tf_R);
        
        tb.addSeparator();

        tb.add(new JLabel("width = "));
        tb.add(tf_width);

        tb.addSeparator();

        tb.add(empty);

        tb.addSeparator();

        JButton b=new JButton(new ImageIcon(getImage(getCodeBase(),"images/play.gif")));
		//b.setPaintBorder(false);
        b.setToolTipText("Rysowanie");
        b.setActionCommand("Paint");
        b.addActionListener(this);
        tb.add(b);
        
        tb.addSeparator();

        b=new JButton(new ImageIcon(getImage(getCodeBase(),"images/color.gif")));
        b.setToolTipText("Wyb�r koloru");
        b.setActionCommand("Color");
        b.addActionListener(this);
        tb.add(b);
        
        tf_sample=new JTextField(2);
        tf_sample.setEditable(false);
        tf_sample.setBackground(kolor);
        tb.add(tf_sample);

        add(tb,BorderLayout.NORTH);

        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        rysunek=new Panel();
        panel.add(rysunek);
        add(panel,BorderLayout.CENTER);
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        String cmd=ae.getActionCommand();
        if(cmd.equals("Paint"))
        {
            n=Integer.parseInt(tf_n.getText());
            k=Integer.parseInt(tf_k.getText());
            R=Integer.parseInt(tf_R.getText());
            width=Integer.parseInt(tf_width.getText());
            paintPolygon=true;
            double alpha=2.0*Math.PI/n;
            double beta=(Math.PI-k*alpha)/2.0;
            r=Math.abs(350*Math.sin(beta)/Math.sin(Math.PI-beta-alpha/2.0));
            polygons.clear();
            if(empty.isSelected())
            {
                Polygon p=new Polygon();
                for(int i=0;i<=n;i++)
                {
                    p.addPoint(350+(int)(350*Math.cos(i*alpha)),350+(int)(350*Math.sin(i*alpha)));
                    if(i<n)
                    {
                        p.addPoint(350+(int)(r*Math.cos(i*alpha+alpha/2)),350+(int)(r*Math.sin(i*alpha+alpha/2)));
                    }
                }
                polygons.add(p);
            }
            else
            {
                HashSet<Integer> vertex = new HashSet<Integer>();
                for(int i=0;i<n;i++)
                {
                    vertex.add(i);
                }
                while(vertex.size()>0)
                {
                    Polygon p=new Polygon();
                    int first=0;
                    while(!vertex.contains(first))
                    {
                        first++;
                    }
                    p.addPoint(350+(int)(350*Math.cos(first*alpha)),350+(int)(350*Math.sin(first*alpha)));
                    vertex.remove(first);
                    int i=(first+k)%n;
                    while(i!=first)
                    {
                        p.addPoint(350+(int)(350*Math.cos(i*alpha)),350+(int)(350*Math.sin(i*alpha)));
                        vertex.remove(i);
                        i=(i+k)%n;
                    }
                    p.addPoint(350+(int)(350*Math.cos(first*alpha)),350+(int)(350*Math.sin(first*alpha)));
                    polygons.add(p);
                }
            }
            repaint();
            return;
        }
        if(cmd.equals("Color"))
        {
            kolor=JColorChooser.showDialog(this,"Kolor wielok�ta",kolor);
            tf_sample.setBackground(kolor);
            repaint();
        }
    }
    //------------------------
    class Panel extends JPanel
    {
        //------------------------
        public Panel()
        {
            super();
            setPreferredSize(new Dimension(700,700));
        }
        //------------------------
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Stroke stroke=new BasicStroke(width);
            Graphics2D g2=(Graphics2D) g;
            g2.setColor(kolor);
            g2.translate(350-R,350-R);
            g2.scale(R/350.0,R/350.0);
            g2.setStroke(stroke);
            if(paintPolygon)
            {
                for(int i=0;i<polygons.size();i++)
                {
                    g2.drawPolygon(polygons.get(i));
                }
            }
        }
    }
}
