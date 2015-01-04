package sorting.sort_count;

import java.util.*;
public class merge_sort {
    public static void main(String[] args) {
        int[] lista = {14, 11, 3, 19, 32, 67, 76, 23, 41, 58, 85};
        System.out.println("przed: " + Arrays.toString(lista));
        mergeSort(lista);
        System.out.println("po: " + Arrays.toString(lista));
    }

    // Kod w tym miejscu umieszcza elementy danej tablicy w posortowanej kolejności
    // za pomocą algorytmu sortowania przez scalanie.
    // Po wykonaniu operacji tablica jest w uporządkowanej kolejności (niemalejącej).
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Dzieli tablicę na dwie części dopóki jej długość jest większa niż 1 element.
            int[] lewa = lewaPolowa(array);
            int[] prawa = prawaPolowa(array);
            
            // Rekurencyjnie sortuje dwie połówki.
            mergeSort(lewa);
            mergeSort(prawa);
            
            // Scala posortowane połówki w posortowaną całość.
            merge(array, lewa, prawa);
        }
    }
    
    // Zwraca pierwszą połowę podanej tablicy.
    public static int[] lewaPolowa(int[] array) {
        int dlugosc1 = array.length / 2;
        int[] lewa = new int[dlugosc1];
        for (int i = 0; i < dlugosc1; i=i+1) {
            lewa[i] = array[i];
        }
        return lewa;
    }
    
    // Zwraca drugą połowę podanej tablicy.
    public static int[] prawaPolowa(int[] array) {
        int dlugosc1 = array.length / 2;
        int dlugosc2 = array.length - dlugosc1;
        int[] prawa = new int[dlugosc2];
        for (int i = 0; i < dlugosc2; i=i+1) {
            prawa[i] = array[i + dlugosc1];
        }
        return prawa;
    }
    
    // Scala podane prawą i lewą tablicę w tablicę wynikową. 
    // Przed wykonaniem operacji: wynik jest pusty, prawa i lewa są posortowane.
    // Po: Tablica wynikowa zawiera wynik scalenia posortowanych list.
    public static void merge(int[] wynik, 
                             int[] lewa, int[] prawa) {
        int indeksL = 0;   // Indeks na lewej tablicy.
        int indeksP = 0;   // Indeks na prawej tablicy.
        
        for (int i = 0; i < wynik.length; i=i+1) {
            if (indeksP >= prawa.length || (indeksL < lewa.length && 
                    lewa[indeksL] <= prawa[indeksP])) {
                wynik[i] = lewa[indeksL];    // Bierze wartość do tablicy wynikowej z tablicy lewej.
                indeksL=indeksL+1;			// Wówczas indeks na lewej tablicy wzrasta o 1 (przechodzi na następny element).
            } else {
                wynik[i] = prawa[indeksP];   // Bierze wartość z tablicy prawej.
                indeksP=indeksP+1;			// Wówczas indeks na prawej tablicy wzrasta o 1.
            }
        }
    }
 }