#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
int moja_funkcja(int skladnik1, int skladnik2)
{
    int roznica;
    roznica=skladnik1-skladnik2;
    return roznica;
}
*/

// 0-32k -> memory allocation

int main()
{
    srand(time(NULL));
    int i=5;
    int wylosowana_liczba;

    char tekst[13]="programowanie";

    for(i=1;i<5;i++)
    {

        //wylosowana_liczba=rand()%100+99;
        wylosowana_liczba=rand()%13;
        printf("%d wylosowana litera z przedzialu to: %c\n",i,tekst[wylosowana_liczba]);

    }



    return 0;
}
