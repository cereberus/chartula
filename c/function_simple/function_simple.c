#include <stdio.h>


int moja_funkcja(int skladnik1, int skladnik2)
{
    int roznica;
    roznica=skladnik1-skladnik2;
    return roznica;
}

int main()
{
    int pierwsza_liczba=5;
    int druga_liczba=3;
    int wynik;

    wynik=moja_funkcja(pierwsza_liczba, druga_liczba);
    printf("Wynikiem operacji jest: %d\n", wynik);

    return 0;
}
