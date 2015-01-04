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

    for(i=1;i<5;i++)
    {

        //wylosowana_liczba=rand()%100+99;
        wylosowana_liczba=rand()%100;
        printf("%d wylosowana liczba z przedzialu <0,99> to: %d\n",i,wylosowana_liczba);

    }



    return 0;
}
