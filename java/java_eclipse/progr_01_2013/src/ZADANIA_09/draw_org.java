package ZADANIA_09;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class draw_org {
	public static void main(String[] args) {
		BufferedImage img = null;
		try {
		    img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		    
		    for (int x=0;x< img.getWidth();x=x+1)
		    {
		    	
		    	
		    	for (int y=0;y< img.getHeight();y=y+1)
		    	{
		    		int rgb = new Color(255, 0, 0).getRGB();
		    	    img.setRGB(x, y, rgb);
		    	}
		    }
		    
		    for (int x=0;x< img.getWidth();x=x+1)
		    {
		    	
		    	
		    	for (int y=0;y< img.getHeight();y=y+1)
		    	{
		    		if ((x-100)*(x-100)+(y-100)*(y-100) < 50*50){
		    		int rgb = new Color(10, 10, 10).getRGB();
		    	    img.setRGB(x, y, rgb);
		    	}
		    		else
		    		{
		    			int rgb = new Color(100, 100, 100).getRGB();
			    	    img.setRGB(x, y, rgb);	
		    		}
		    	}
		    }
		    
		    
		
		    
		    
		    File outputfile = new File("C:/zad_03.png");
		    ImageIO.write(img, "png", outputfile);  
		} catch (IOException e) {
		}
	}
}