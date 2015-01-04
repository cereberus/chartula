package ZADANIA_09;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class zad_02 {
	public static void main(String[] args) {
		BufferedImage img = null;
		try {
		    img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		    
		    for (int x=0;x< img.getWidth()/2;x=x+1)
		    {
		    	for (int y=0;y< img.getHeight();y=y+1)
		    	{
		    		int rgb = new Color(255, 0, 0).getRGB();
		    	    img.setRGB(x, y, rgb);
		    	}
		    }
		    
		    for (int x=img.getWidth()/2;x< img.getWidth();x=x+1)
		    {
		    	for (int y=0;y< img.getHeight();y=y+1)
		    	{
		    		int rgb = new Color(50, 50, 200).getRGB();
		    	    img.setRGB(x, y, rgb);
		    	}
		    }
		    
		    
		    File outputfile = new File("C:/zad_02.png");
		    ImageIO.write(img, "png", outputfile);  
		} catch (IOException e) {
		}
	}
}