#include <stdio.h>
#include <time.h>

int main()
{
    int cyfra=0;
    clock_t start;
    clock_t koniec;
    int czas_trwania;
    int czas_reakcji;
    int reaction_times[7];
    int suma = 0;
    float srednia;

    int wyrazy[7];
    wyrazy[0] = 23;
    wyrazy[1] = 12;
    wyrazy[2] = 87;
    wyrazy[3] = 97;
    wyrazy[4] = 65;
    wyrazy[5] = 51;
    wyrazy[6] = 49;

    printf("\nKliknij cos\n");

    int mierzenie(){
        start=clock();
        while(cyfra!=1 || cyfra!=2)
        {
            scanf("%d",&cyfra);
            if(cyfra==1){
                break;
            }
            if(cyfra==2){
                break;
            }
            else{
                printf("\nNacisnales cos innego niz '1' lub '2'.\n");
            }
        }
        koniec=clock();
        czas_trwania=(int)(koniec-start);

        return czas_trwania;
    }


///////////////////////////////////////


   // printf("\nPetla 'while' byla wykonywana przez %d ms.\n", czas_trwania);

    printf("\nBedzie Ci zaprezentowana pewna liczba\n");
    printf("Jezli liczba jest wieksza niz 50 kliknij '1' jesli wieksza kliknij '0'.\n");
    printf("Wybor zatwierdz prosze enterem.\n");

    int i;

    for(i=0;i<(int)( sizeof(wyrazy) / sizeof(wyrazy[0]) );i++){
        /////////////////////////////////
        printf("\n%d\n", wyrazy[i]);

        czas_reakcji=mierzenie();
        //printf("%d", czas_reakcji);
        reaction_times[i] = czas_reakcji;
        /////////////////////////////////

    }

    printf("\nWyniczek");

    for(i=0;i<(int)( sizeof(reaction_times) / sizeof(reaction_times[0]) );i++){
        printf("\nCzas reakcji %d: %d", i+1, reaction_times[i]);
    }

    for(i=0;i<(int)( sizeof(reaction_times) / sizeof(reaction_times[0]) );i++){
        suma += reaction_times[i];
    }

    srednia=suma/ ( sizeof(reaction_times) / sizeof(reaction_times[0]));
    printf("\n\nSredni czas reakcji %f\n", srednia);


}
