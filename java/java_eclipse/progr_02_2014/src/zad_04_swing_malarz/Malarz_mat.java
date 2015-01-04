package zad_04_swing_malarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Malarz_mat extends JFrame implements ActionListener, ChangeListener
{
   
    private BufferedImage img = null;    
    private PanelRysowania panel = null;
    private JButton open= null;
    private JButton colorch= null;
    private JButton play1 = null;
    private JButton play2 = null;
    private int height = 0;
    private int width = 0;
    private JFileChooser fc = new JFileChooser(); 
    private JCheckBox cb = new JCheckBox("Powielac Obrazek:", false);
    private JTextField tf_sample1 = new JTextField(4);
    private Color color1 = new Color(100,100,100,255);
    private JLabel label = new JLabel("Wsp. przezroczystosci");
    private JTextField trancoef = new JTextField("1", 2);
    private boolean kurtyna = false;
    private float transp = 1;
    private int transp2 = 0;
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
        new Malarz_mat();
    }
    //------------------------
    public Malarz_mat()
    {
        setTitle("Mateusz Ignaszak");
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
        open = new JButton (new ImageIcon("Open.gif"));
        open.addActionListener(this);
        open.setToolTipText("Wybor pliku graficznego");
        tb.add(open);
        tb.addSeparator();
        
        cb.addChangeListener(this);
        tb.add(cb);
        tb.addSeparator();
        
        colorch =  new JButton (new ImageIcon("Open.gif"));
        colorch.addActionListener(this);
        colorch.setToolTipText("Wybor koloru tla");
        tb.add(colorch);
        tb.addSeparator();
        
       
    	tf_sample1.setEditable(false);
        tf_sample1.setBackground(color1);
        tb.add(tf_sample1);
        tb.addSeparator();
        
        tb.add(label);
        tb.addSeparator();
        
        tb.add(trancoef);
        tb.addSeparator();
        
        play1 =  new JButton (new ImageIcon("Play.gif"));
        play1.addActionListener(this);
        play1.setToolTipText("Wyswietl kurtyne");
        tb.add(play1);
        
        play2 =  new JButton (new ImageIcon("Play.gif"));
        play2.addActionListener(this);
        play2.setToolTipText("Podnies kurtyne");
        tb.add(play2);
        return tb;
    }
    //------------------------
    
    //----------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource());
        
        if (src == colorch)
        {
        	Color color = JColorChooser.showDialog(this,"Kolor tla",this.color1);
        	if(color != null)
            {
                tf_sample1.setBackground(color);
                this.color1 = color;
            }
           
        }
        
        if (src == play1)
        {
        	kurtyna = true;
        }
        if (src == play2)
        {
        	kurtyna = false;
        }
        
        if(src == open)
        {
            if (fc.showOpenDialog(this) ==JFileChooser.APPROVE_OPTION)
            {
            	
            try
            {
            	img = ImageIO.read(fc.getSelectedFile()); 
            
            }
            catch (Exception e)
            {
            	JOptionPane.showMessageDialog(this,e.toString(),"",JOptionPane.ERROR_MESSAGE);
            }
            }
        }
        repaint();
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
            if (!cb.isSelected())
            {
            	if (img!=null)
            	g.drawImage(img, 0, 0, null); 							
            }
            if (cb.isSelected())
            {
            	if (img!=null)
            	{
	            	int w = img.getWidth();
	            	int h = img.getHeight();
	            	for (int j=0;j<=height/h+1;j++)
	            	{
	            	
	            	for (int i=0;i<=width/w+1;i++)
	            	{
	            		g.drawImage(img, i*w, j*h, null);
	            	}
	            	}
            	}
            }
            
            
            
            if (kurtyna)
            {
            	try
				{
					transp = Float.parseFloat(trancoef.getText());
					if (transp>1)
					{
						transp=1;
						trancoef.setText("1");
					}
					if (transp<0)
					{
						transp=0;
						trancoef.setText("0");
					}
					
				}
				catch (Exception e1)
				{		
				}
            	transp2 = Math.round(transp*255);
            	Color kolor1 = new Color (color1.getRed(),color1.getGreen(),color1.getBlue(),transp2);
            	g.setColor(kolor1); 
                g.fillRect(0,0, width, height); 
                
               
            }
            
        } 
    }
	
	public void stateChanged(ChangeEvent e) 
	{
		repaint();
	}
}
