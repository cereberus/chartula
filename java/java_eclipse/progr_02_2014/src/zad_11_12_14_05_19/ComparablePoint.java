package zad_11_12_14_05_19;

import java.awt.*;

public class ComparablePoint extends Point implements Comparable
{
    public ComparablePoint(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    //------------------------
    public int compareTo(Object ob)
    {
        Point p = (Point)ob;
        double distance1 = Math.hypot(x,y);
        double distance2 = Math.hypot(p.x,p.y);
        if(this.equals(p))
        {
            return 0;
        }
        else if(distance1 > distance2)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    //------------------------
    public String toString()
    {
        return "x="+x+",y="+y+",distance="+Math.hypot(x,y);
    }
}