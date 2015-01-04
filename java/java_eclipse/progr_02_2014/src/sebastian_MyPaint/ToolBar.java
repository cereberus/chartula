package sebastian_MyPaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToolBar extends JPanel {
	
	
	private static final long serialVersionUID = 3L;
	
	private ImageWindow imageWindow;
	
	private JButton lineBtn, squareBtn, lineClickBtn, penColorBtn, brushColorBtn, clearBtn;		
	
	public ToolBar(ImageWindow imgWnd)
	{
		
		
		this.setBackground(new Color(200,200,200));
		
		imageWindow = imgWnd;
		
		lineBtn		= new JButton("",new ImageIcon("Line2P.png"));
		squareBtn	= new JButton("",new ImageIcon("LineRectangle.png"));
		lineClickBtn = new JButton("",new ImageIcon("Line2P.png"));
		penColorBtn = new JButton("",new ImageIcon("Line2P.png"));
		brushColorBtn = new JButton("",new ImageIcon("Line2P.png"));
		clearBtn = new JButton("",new ImageIcon("Line2P.png"));
		
		lineBtn.addActionListener(new ToolListener());
		lineBtn.setToolTipText("Line");
		squareBtn.addActionListener(new ToolListener());
		squareBtn.setToolTipText("Square");
		lineClickBtn.addActionListener(new ToolListener());
		lineClickBtn.setToolTipText("Line Click");
		penColorBtn.addActionListener(new ToolListener());
		penColorBtn.setToolTipText("Pen Color");
		brushColorBtn.addActionListener(new ToolListener());
		brushColorBtn.setToolTipText("Brush Color");
		clearBtn.addActionListener(new ToolListener());
		clearBtn.setToolTipText("Clear");
		
		
		
		this.setLayout(new GridLayout(9,1)); 
		this.add(lineBtn);
		this.add(squareBtn);
		this.add(lineClickBtn);
		this.add(penColorBtn);
		this.add(brushColorBtn);
		this.add(clearBtn);
		
	}
	
	
	private class ToolListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{	
			
			if(event.getSource() == lineBtn)
			{
				imageWindow.setDrawMode(ImageWindow.LINE);		
			}
			else if(event.getSource() == squareBtn)
			{
				imageWindow.setDrawMode(ImageWindow.SQUARE);		
			}
			else if(event.getSource() == lineClickBtn)
			{
				imageWindow.setDrawMode(ImageWindow.LINE_CLICK);
				imageWindow.lineFirst = false;
			}
			else if(event.getSource() == penColorBtn)
			{
				
			   Color color = JColorChooser.showDialog(imageWindow, "Select Pen Color", imageWindow.getPenColor());
			   if (color != null)
			   {
				   imageWindow.setPenColor(color);
			   }
			   
			   
			}
			else if(event.getSource() == brushColorBtn)
			{
				
			   Color color = JColorChooser.showDialog(imageWindow, "Select Brush Color", imageWindow.getPenColor());
			   if (color != null)
			   {
				   imageWindow.setBrushColor(color);
			   }
			   
			}
			else if(event.getSource() == clearBtn)
			{
				
			   imageWindow.getElements().clear();
			   imageWindow.repaint();
			   
			}
			
			
					
		}//actionPerformed
	}//ToolListener
	
	

}
