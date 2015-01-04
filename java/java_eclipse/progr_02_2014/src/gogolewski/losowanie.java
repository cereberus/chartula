package gogolewski;
//�wiczenia 6-8, zadanie 3, losuje dwie tablice, wy�wietla je, a nast�pnie liczy ich iloczyn
import java.util.Random;

public class losowanie {

    public static void main(String[] args) {
       Random r=new Random();
       int x=5;  //rozmiar tablic
       int [][]a=new int[x][x];
       int [][]b=new int[x][x];
       int [][]c=new int[x][x];
       System.out.print("Tablica A:\n");
        for(int i=0; i<x; i++){ //p�tla id�ca po kom�rkach
          System.out.print(i+1+":   "); //numeracja wierszy
          for(int j=0; j<x; j++){  //p�tla id�ca po wierszach
            a[i][j]=r.nextInt(3)+1;  //losowanie z zakresu -999,999 na zasadzie (max-min+1)+min
            System.out.print(a[i][j]+" ");
          }System.out.println("");
      }
         System.out.print("\nTablica B:\n");
         for(int i=0; i<x; i++){ //p�tla id�ca po kom�rkach
          System.out.print(i+1+":   "); //numeracja wierszy
          for(int j=0; j<x; j++){  //p�tla id�ca po wierszach
            b[i][j]=r.nextInt(3)+1;  //losowanie z zakresu 1,3 na zasadzie (max-min+1)+min
            System.out.print(b[i][j]+" ");
          }System.out.println("");
      }
      int s;
      for(int i = 0; i < x; i++){ //kom�rki
       for(int j = 0; j < x; j++) //wiersze
        {
            s = 0;
            for(int k = 0; k < x; k++) s += a[i][k] * b[k][j]; //tworzy now� zmienn� k
            c[i][j] = s;
        }   
      }
       System.out.print("\nIloczyn tablic:\n");
     for(int i=0; i<x; i++){ //p�tla id�ca po kom�rkach
          System.out.print(i+1+":   "); //numeracja wierszy
          for(int j=0; j<x; j++){  //p�tla id�ca po wierszach
            System.out.print(c[i][j]+" ");
          }System.out.println("");   
        
        
    }
    
}}
