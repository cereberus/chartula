package zad_11_12_14_05_19;

import java.awt.*;
import java.util.*;

public class MyComparator implements Comparator<Point>
{
    public int compare(Point p1,Point p2)
    {
        double distance1 = Math.hypot(p1.x,p1.y);
        double distance2 = Math.hypot(p2.x,p2.y);
        if(p1.equals(p2))
        {
            return 0;
        }
        else if(distance1 > distance2)
        {
            return -1;
        }
        else
        {
            return 1;
        }    
    }
}