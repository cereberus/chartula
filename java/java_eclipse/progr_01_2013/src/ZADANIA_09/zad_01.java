package ZADANIA_09;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.lang.Math;


public class zad_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedImage img = null;
		try {
		    //img = ImageIO.read(new File("/home/student-67/workspace/strawberry.png"));
		    img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		    for (int x=0;x< img.getWidth();x=x+1)
		    {
		    	for (int y=0;y< img.getHeight();y=y+1)
		    	{
		    		
		    		int rgb = new Color(10, 200, 250).getRGB();
		    	    img.setRGB(x, y, rgb);
		    	}
		    }
		    
		    for (int x=img.getWidth()/2;x< img.getWidth();x=x+1)
		    {
//		    	for (int y=img.getHeight()/2;y< img.getHeight()/2+1;y=y+1)
//		    	{
//		    		if ()
//		    		int rgb = new Color(10, 100, 10).getRGB();
//		    	    img.setRGB(x, y, rgb);
//		    	}
		    }
		
		    File outputfile = new File("C:/saved3.png");
		    ImageIO.write(img, "png", outputfile);
		    
		} catch (IOException e) {
		}
	}

}

