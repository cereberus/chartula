package zad_04_swing_malarz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import zad_04_swing_malarz.Malarz.PanelRysowania;


//deklaracje importu
 
public class Zad_mine extends JFrame implements ActionListener,ChangeListener
{
    //definicje pól (składowych klasy)
    private BufferedImage img = null;
	private PanelRysowania panel;    
	private JButton open = new JButton(/*tutaj napis przycisku ("napis") albo ikonka:*/new ImageIcon("Open.gif"));
	private JFileChooser fc = new JFileChooser("."); //w nawiasie można nic nie pisać - jeśli nie napiszemy nic, to będzie konto domowe użytkownika, pojdyncza kropka to katalog bieżący
    private JCheckBox cb = new JCheckBox("czy powiela�",false /*albo "selected"*/);
    private JButton color = new JButton();
    private JColorChooser cc = new JColorChooser();
    private Color kolor = new Color(123,178,205);
    private ArrayList<int[]> disks = new ArrayList<int[]>();
    private Boolean courtain = false;
    private JButton showCurtain = new JButton();
    private JButton delete = new JButton();
    private JButton colorInfo = new JButton();    
//    private panel;
//    private Boolean src = false;
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
        new Zad_mine();
    }
    //------------------------
    public Zad_mine()
    {
        setTitle("Mikolaj Buchwald");
        setLayout(new BorderLayout(2,2));
               
        add(createToolBar(),BorderLayout.NORTH);
        
//        panel = new PanelRysowania();
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
        open.addActionListener(this);
        open.setToolTipText("Wyb�r pliku graficznego");//dymek z podpowiedzią
        tb.add(open);
        tb.addSeparator();
        
        cb.addChangeListener(this);
        tb.add(cb);
        tb.addSeparator();
        
        color.addActionListener(this);
        color.setToolTipText("Wybór koloru");
        tb.add(color);
        tb.addSeparator();
        
        //umieszczenie komponentów na pasku narzędzi JToolBar
        return tb;
    }
    //------------------------
    public void actionPerformed(ActionEvent ae)
    {
        JButton src = (JButton)(ae.getSource()); //co bylo zrodlem, robimy rzutowanie na przycisk
        //obsługa kliknięcia w przycisk
        //zakładam, że obiekt JFileChooser nazywa się fc, a przycisk otwierania pliku open
        if(src == open)
        {
            if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION);
            {
            try 
            {
				img = ImageIO.read(fc.getSelectedFile());
			} 
            catch (IOException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        
            //...
          	if(src == showCurtain)
          	{
          		courtain = false;
          		repaint();
          	}
        	if(src == delete)
        	{
        		courtain = false;
        		repaint();
        	}
        	if(src == color)
        	{
        		JColorChooser chooser = new JColorChooser();
        		kolor = chooser.showDialog(this,"", kolor);
        		colorInfo.setBackground(kolor);
        		repaint();
        	}
            
        
    }
    //------------------------
    class PanelRysowania extends JPanel
    {
       	private int width;
		private int height;
		private boolean courtain;
		private AbstractButton tf;
		public PanelRysowania()
        {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dim.width-=100;
            dim.height-=160;
            width = dim.width; 
            height = dim.height;
            setPreferredSize(dim);
            setBackground(Color.WHITE);
            
            addMouseLinstener(new MouseAdapter()
            {
            	public void mouseClicked(MouseEvent me)
            	{
            		x = me.getX();
            		y = me.getY();
            		int[] tab = new int[2];
            		tab[0] = x;
            		tab[1] = y;
            		disks.add(tab);
            		repaint();
            		
            	}
            }
            
            
        }
        //-------------------
        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            //malowanie
            
            g.setColor(new Color(187,203,155));
            for (int i=0;i<disks.size();i++){
            	int[] t = disks.get(i);
            	g.fillOval(t[0]-10, t[1]-10, 20, 20);
            }
            
            
            if(courtain)
            {
            	double alfa = Double.parseDouble(tf.getText());
            	g.setColor(new Color(kolor.getRed(),kolor.getGreen(),kolor.getBlue(),(int)(255*alfa)));
            	g.fillRect(0,0,width+20,height+20);
            	
            }
            
            if(img != null) //! to negacja, czyli != to znaczy "nie jest równe", a == to znaczy "równe"
            {
            	if(!cb.isSelected())
            	{
            		//jeśli ustawiamy to set, jeśli odczytujemy to get + jeśli logiczna to is
            	g.drawImage(img, 0, 0, null);
            	}
            	else
            	{
            		int w = img.getWidth();
            		int h = img.getHeight();
            		for (int i=0;i<width/w+1/*szer. pola/szer.obrazka + 1*/;i++)
            		{
            			for (int j=0;j<height/w+1/*szer. pola/szer.obrazka + 1*/;j++)
            			{
            			g.drawImage(img,i*w,j*h,null); //powielanie w poziomie
            		}
            	
            	}
            	
            }
        
        } 
    }}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		repaint(); //odmaluj po zaznaczeniu ptaszka w checkboxie
		
	}
}