package sebastian_MyPaint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MyPaint extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ImageWindow imageWindow;
	private ToolBar toolBar;
	private JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newItem, openItem, closeItem, saveItem, exitItem;
	
	
	private void setMenu()
	{
		

		menuBar 		= new JMenuBar();
		setJMenuBar(menuBar);

		fileMenu  	= new JMenu("File");
		fileMenu.setMnemonic('F');
		
		newItem		= new JMenuItem("New");
		openItem 	= new JMenuItem("Open");
		closeItem 	= new JMenuItem("Close"); 
		saveItem 	= new JMenuItem("Save");
		exitItem	= new JMenuItem("Exit");
		
		newItem.addActionListener(new menuListener());
		saveItem.addActionListener(new menuListener());
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);
		
	}
	
	
	public class menuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == newItem )
			{
				imageWindow.getElements().clear();
				imageWindow.setDrawMode(0);
				imageWindow.repaint();
			}
			
			if(event.getSource() == saveItem )
			{
				imageWindow.Save();
				
			}
			//reaguje na open z klasy imageWindow
			if(event.getSource() == openItem )
			{
				imageWindow.Open();
			
			}
		}
	}
	
	
	public MyPaint()
	{

		imageWindow = new ImageWindow();
		
		toolBar = new ToolBar(imageWindow);
		toolBar.setPreferredSize(new Dimension(50,500));
		
		
		setMenu();
		
		Container c = this.getContentPane();  
	    c.add(toolBar,"West");  
	    c.add(imageWindow,"Center");
		
		setSize(800,600);
		this.setResizable(false);
		setVisible(true);

	}
	
	
	

	
	public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {

                MyPaint paint = new MyPaint();
                paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paint.setVisible(true);
            }
        });
    }
	
}



