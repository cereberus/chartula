#include <stdio.h>
#include <stdlib.h>

int main()
{
    char next;
    int age_napoleon;
    int bitwa;
    int revolta;
    int krol;
    int wojna;
    int wynik;

    wynik = 0;
    printf("TEST. Udzielaj odpowiedzi poprzez klikanie odpowiednich liter (a/b/c/). Uzywaj malych liter.\n\n");
    printf("Kliknij cokolwiek aby rozpoczac test.\n\n");

    printf("Ile mial lat Napoleon gdy zostal Cesarzem Francuzow?\n ");
    printf("1. 34\n 2. 35\n 3. 36\n");
    scanf("%d", &age_napoleon);

    if(age_napoleon==1){
        wynik+=0;
    }
    else if(age_napoleon==2){
        wynik+=1;
    }
    else if(age_napoleon==3){
        wynik+=0;
    }
    else{
        printf("Wcisnales cos innego niz 1, 2 lub 3.\n");
    }

    printf("Kiedy rozegrala sie bitwa pod Waterloo?\n ");
    printf("1. 1814\n 2. 1815\n 3. 1816\n");
    scanf("%d", &bitwa);

    if(bitwa==1){
        wynik+=0;
    }
    else if(bitwa==2){
        wynik+=1;
    }
    else if(bitwa==3){
        wynik+=0;
    }
    else{
        printf("Wcisnales cos innego niz 1, 2 lub 3.\n");
    }

    printf("W jakim miesiacu wybuchla Wielka Rewolucja Francuska?\n ");
    printf("1. lipiec \n 2. sierpien\n 3. wrzesien\n");
    scanf("%d", &revolta);

    if(age_napoleon==1){
        revolta+=1;
    }
    else if(age_napoleon==2){
        revolta+=0;
    }
    else if(age_napoleon==3){
        revolta+=0;
    }
    else{
        printf("Wcisnales cos innego niz 1, 2 lub 3.\n");
    }

    printf("Kto byl ostatnim krolem polski?\n ");
    printf("1. Stanislaw August\n 2. Kazimierz Wielki\n 3. Boleslaw Chrobry\n");
    scanf("%d", &krol);

    if(krol==1){
        wynik+=1;
    }
    else if(krol==2){
        wynik+=0;
    }
    else if(krol==3){
        wynik+=0;
    }
    else{
        printf("Wcisnales cos innego niz 1, 2 lub 3.\n");
    }

    printf("W ktorym roku rozpoczela sie wojna 100-letnia?\n ");
    printf("1. 1222\n 2. 1453\n 3. 1337\n");
    scanf("%d", &age_napoleon);

    if(age_napoleon==1){
        wynik+=0;
    }
    else if(age_napoleon==2){
        wynik+=0;
    }
    else if(age_napoleon==3){
        wynik+=1;
    }
    else{
        printf("Wcisnales cos innego niz 1, 2 lub 3.\n");
    }

    printf("Odpowiedziales poprawnie na %d pytan.\n", wynik);
    if(wynik<3){
        printf("Jestes kiepski z historii.");
    }
    else if(wynik==3){
        printf("Jestes sredni z historii.");
    }
    else{
        printf("Jestes dobry z historii.");
    }

    return 0;


}
