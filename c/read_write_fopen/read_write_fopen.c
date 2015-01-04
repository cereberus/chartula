#include <stdio.h>

int main()
{

    FILE *plik;

    plik=fopen("pierwszy.txt","w");
    fprintf(plik,"marcin");
    fclose(plik);

    return 0;
}
