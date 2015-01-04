package ZADANIA_04;

public class Zadanie_1_tablice {
    public static void main(String[] args) {
int[] tab = new int[5];
tab[0]= 4;
tab[1]= 2;
tab[2]= 7;
tab[3]= 6;
tab[4]= 1;
System.out.println(" dlugosc listy "+ (tab.length));

//for (int i=0;i<tab.length;i=i+1)
//{
//  		System.out.println(i+" ty element to "+ tab[i]);
//}


for (int i=tab.length-1;i>-1;i=i-1)
{
  		System.out.println(i+" ty element to "+ tab[i]);
}
  }
}