package sebastian_MyPaint;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import javax.imageio.*;
import java.io.*;

public class ImageWindow extends JPanel {
	
	
	private static final long serialVersionUID = 2L;
	
	
	protected final static int LINE=1, SQUARE=2, LINE_CLICK=3;
	
	private int  drawMode=0;
	
	private int x1,x2,y1,y2;
	boolean lineFirst;
	
	private ArrayList<Data>   elements = new ArrayList<Data>(),
	bin = new ArrayList<Data>();
	private Color penColor;
	private Color brushColor;
	private Color backgroundColor;
	
	
	private File fileName;
	
	
	
	@Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    } 
	
	
	private void doDrawing(Graphics g) 
	{

		
		
		Graphics2D g2d = (Graphics2D) g; 
        
		
		
		for(Data data: elements) 
		{
			g2d.setColor(data.color);
			
			if (data.mode == LINE)
	        {		
				g2d.drawLine(data.x1, data.y1, data.x2, data.y2);
	        }
			if (data.mode == SQUARE)
	        {
				g2d.drawRect(Math.min(data.x1,data.x2), Math.min(data.y1,data.y2), Math.abs(data.x2-data.x1), Math.abs(data.y2-data.y1));
	        }
			if (data.mode == LINE_CLICK)
	        {		
				g2d.drawLine(data.x1, data.y1, data.x2, data.y2);
	        }
			
		}//for
		
		g2d.setColor(penColor);
		
		//poni�sze linie tylko po to, aby by�o wida� proces rysowania w tych dw�ch przypadkach
		if (drawMode == SQUARE )
        {
			g2d.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        }
		else if (drawMode == LINE )
        {
			g2d.drawLine(x1, y1, x2, y2);
        }
		
	
	}
	
	
	
	
	
	
	public ImageWindow()
	{
		this.setBackground(new Color(255,255,255));
		setListeners();	
		
		penColor = Color.RED;
		brushColor = Color.RED;
		backgroundColor = Color.WHITE;
		
		setBackground(backgroundColor);
	
		
	}
	
	
	
	void setListeners()
	{
		addMouseListener(new MouseAdapter()
	    {
	       public void mousePressed(MouseEvent m)
	       {
	            x1  = m.getX();
	            y1  = m.getY();
	            
	            if (lineFirst)
	            {
	            	x1 = x2;
	            	y1 = y2;
	            	x2 = m.getX();
	 	            y2 = m.getY();
	            }
	            
	           
	       }
	       
	       public void mouseReleased(MouseEvent m)
	       {
	    	   x2 = m.getX();
	           y2 = m.getY();
	           
	           if (drawMode == LINE_CLICK )
	        	   {
	        	   		lineFirst = !lineFirst;
	        	   		
	        	   }
	    
	           elements.add(new Data(drawMode,x1,y1, x2, y2, penColor));
	             
	           repaint();
	       }
	       
	       
	       public void mouseEntered(MouseEvent event)
	       {
	    	   setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	       }

	       public void mouseExited(MouseEvent event)
	       {
	    	   setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	       }
	       
	       public void mouseClicked(MouseEvent event){}
	       
	       
	     });

	     addMouseMotionListener(new MouseMotionAdapter()
	     {
	        public void mouseDragged(MouseEvent m)
	           {
	        	x2 = m.getX();
	            y2 = m.getY();
	       
	            
	            
	            repaint();
	            
	           }
	        
		   
	        public void mouseMoved(MouseEvent event){}

	       });

	}
	
	
	
	
	
	
	public void setDrawMode(int mode)
	{
		drawMode = mode;
	}
	
	public int getDrawMode()
	{	
		return drawMode;	
	}
	

	public void setPenColor(Color color)
	{
		penColor = color;
	}
	
	public Color getPenColor()
	{	
		return penColor;	
	}

	
	public void setBrushColor(Color color)
	{
		brushColor = color;
	}
	
	public Color getBrushnColor()
	{	
		return brushColor;	
	}

	
	public ArrayList<Data> getElements()
	{	
		return elements;	
	}
	
	
	
	
	
	public void SaveAs()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		int result = fileChooser.showSaveDialog(null);
	
		if(result == JFileChooser.CANCEL_OPTION) return;
			
		fileName = fileChooser.getSelectedFile();

		if(fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(null,"Niew�a�ciwa nazwa pliku", "MyPaint",JOptionPane.ERROR_MESSAGE);
		else
		{	
			try
			{
				FileOutputStream plik = new FileOutputStream(fileName);
				ObjectOutputStream strumien = new ObjectOutputStream(plik);
				strumien.writeObject(elements);
				JOptionPane.showMessageDialog(null,"File Saved","Painter",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception exp){}
			
			
		}		    
	repaint();
	}
	
	
	public void Save()
	{
		if(fileName != null)
		{
			
			
			try
			{
				FileOutputStream plik = new FileOutputStream(fileName);
				ObjectOutputStream  strumien = new ObjectOutputStream(plik);
				strumien.writeObject(elements);
				JOptionPane.showMessageDialog(null,"File Saved","Painter",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception exp){}
			
			
		}
		else
		{
			SaveAs();
		}
		repaint();
	}
	
	public void Open()
	
			{JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);	
			int result = fileChooser.showSaveDialog(null);
		
			if(result == JFileChooser.CANCEL_OPTION) return;
				
			fileName = fileChooser.getSelectedFile();

			if(fileName == null || fileName.getName().equals(""))
				JOptionPane.showMessageDialog(null,"Niew�a�ciwa nazwa pliku", "MyPaint",JOptionPane.ERROR_MESSAGE);
			else
			{	
			try
			{
				FileInputStream nowy = new FileInputStream(fileName);
				ObjectInputStream  strumien2 = new ObjectInputStream(nowy);
				strumien2.readObject();
				JOptionPane.showMessageDialog(null,"File Opened","Painter",JOptionPane.INFORMATION_MESSAGE);
				strumien2.close();
			}catch(Exception exp){}
			
			
	
		}
		repaint();
	}
	
/*----------------------------------------------Data Class--------------------------------*/
	

private class Data implements Serializable
{
	private int mode;
	private int x1, y1, x2, y2;
	
	private int width, height;
	
	private Color color;
	
	public Data(int mode, int x1, int y1, int x2, int y2, Color color)
	{
		this.mode = mode;
		this.x1= x1; this.x2= x2;
		this.y1= y1; this.y2= y2;
		this.color = color;
	}
	
	
	int getMode()
	{
		return mode;
	}
	
}//Data calss


}//ImageWindow class
	
	
		


