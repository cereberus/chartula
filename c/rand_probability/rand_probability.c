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
// printf("%d\n\n", sizeof(tekst));

int main()
{
    srand(time(NULL));
    int i;
    int wylosowana_liczba;
    int nowa_wylosowana_liczba;

    for(i=0;i<10;i++)
    {
        wylosowana_liczba=rand()%100;
        if(wylosowana_liczba>20)
        {
            printf(" bardzo czesty napis\n");
        }
        else
        {
            printf("rzadki napis\n");
        }
    }

    return 0;
}
