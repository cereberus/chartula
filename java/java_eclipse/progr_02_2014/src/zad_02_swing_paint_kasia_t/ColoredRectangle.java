package zad_02_swing_paint_kasia_t;

import java.awt.*;

public class ColoredRectangle extends Rectangle
{
    public Color color;
    public int stroke;
    //------------------------
    public ColoredRectangle(int x,int y,int width, int height,Color color,int stroke)
    {
        super(x,y,width,height);
        this.color = color;
        this.stroke = stroke;
    }    
}