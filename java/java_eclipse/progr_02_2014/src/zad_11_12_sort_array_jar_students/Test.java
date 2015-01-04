package zad_11_12_sort_array_jar_students;

import java.util.*;
import java.awt.*;

public class Test
{
    public static void main(String[] args)
    {
        Point[] points = new ComparablePoint[10];
        Random r = new Random();
        for(int i=0;i<points.length;i++)
        {
            points[i] = new ComparablePoint(r.nextInt(101),r.nextInt(101));
            System.out.println(points[i]);
        }
        System.out.println("Po posortowaniu domyslnym (rosnacym)");
        Arrays.sort(points);
        for(int i=0;i<points.length;i++)
        {
            System.out.println(points[i]);
        }
        System.out.println("Po innym posortowaniu (malejacym)");
        Arrays.sort(points,new MyComparator());
        for(int i=0;i<points.length;i++)
        {
            System.out.println(points[i]);
        }         
    }
}