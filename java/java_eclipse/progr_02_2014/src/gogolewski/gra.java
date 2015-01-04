package gogolewski;
//package zgadywanie;

import java.util.Random;
import java.util.Scanner;

public class gra {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner k = new Scanner(System.in); 
        int liczba = -1;
        int nr = 1;
        int liczbakomputera = r.nextInt(100); 
        System.out.print("\nZgadnij liczb�!\n");
        do {
            liczba = k.nextInt();
            if (liczba > liczbakomputera) {
                System.out.printf("\nRunda %d : Za du�o!\n", nr);
            } else if (liczba < liczbakomputera) {
                System.out.printf("\nRunda %d : Za ma�o!\n", nr);
            } else {
                System.out.printf("Runda %d : Zgad�e�!\n", nr);
            }
            nr++;
        } while (liczba != liczbakomputera);
        System.out.print(liczbakomputera);

    }
}
