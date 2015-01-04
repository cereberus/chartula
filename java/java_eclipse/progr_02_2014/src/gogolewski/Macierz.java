package gogolewski;
//�wiczenia 6-8, zadania 1 i 2, losuje tablice 10x10 i mno�y tablic� przez liczb� podan� przez u�ytkownika
import java.util.Scanner;
import java.util.Random;

public class Macierz {
    
    public static void main(String[] args) {
       Scanner k=new Scanner(System.in);
       Random r=new Random();
       
      int [][]tab=new int[10][10]; //tworzymy tablice, w ktorej sa liczby calkowite. wymiary tablicy 10x10
      for(int i=0; i<10; i++){ //petla przewija sie po wierszach
          System.out.print(i+1+":   "); //numer wiersza
        for(int j=0; j<10; j++){  //petla przewija sie po kolumnach
            tab[i][j]=r.nextInt(999-(-999)+1)-999;  //losowanie z zakresu -999,999 na zasadzie (max-min+1)+min
            System.out.print(tab[i][j]+" "); // printuje elemen tablicy
        }System.out.println("");
      }
      
    int max=-1000;  //-1000 najwyzsza mozliwa wartoscia
    int x1=0,y1=0;  //wsp�rz�dne max
    int min=1000;   //1000 wartosc o jeden mniejsza niz najmniejsza mozliwa
    int x2=0, y2=0; // wsp�rz�dne min
    for(int i=0; i<10; i++){   
        for(int j=0; j<10; j++){
            if(tab[i][j]>max){  //je�li aktualne miejsce w tablicy jest wi�ksze niz dotychczasowy max
            max=tab[i][j];   //max staje si� aktualnym miejscem
            x1=i+1;        //wsp�rz�dne max zapisujemy w aktualnym miejscu tablicy
            y1=j+1;}        //tablice s� indeksowane od 0 wi�c +1 aby by�o intuicyjnie
            if(tab[i][j]<min){  //to samo dla min
            min=tab[i][j];
            x2=i+1; 
            y2=j+1;
            }
        }
    }
    System.out.format("\nWsp�rz�dne najwi�kszej warto�ci (%d): %d %d\n", max,x1,y1);
    System.out.format("Wsp�rz�dne najmniejszej warto�ci (%d): %d %d\n", min,x2,y2); //wy�wietla obie warto�ci
    System.out.print("Podaj liczb� przez kt�r� chcesz przemno�y� tablic�: ");
    int x=k.nextInt();  //wprowadzanie liczby z klawiatury 
    System.out.println("");//nowa linia dla przejrzysto�ci 
     for(int i=0; i<10; i++){   
        System.out.print(i+1+":   ");
        for(int j=0; j<10; j++){
          tab[i][j]=tab[i][j]*x;
          System.out.print(tab[i][j]+" ");
         }System.out.println("");}//�amanie wiersza 
    }
    
    
}
