#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <conio.h>

int main()
{
char znak;

while(znak!='q'){
    system("COLOR 02");
    printf("Co chcesz zrobic?\n\n");
    printf("(a) Info o autorze.\n");
    printf("(b) Kolory niezgodne.\n");
    printf("(c) Kolory zgodne.\n");
    printf("(d) Niespodziewajka.\n\n");
    printf("Wcisniecie 'q' zakonczy dzialanie programu.\n\n");
    printf("Wcisniecie innego przycisku nie zrobi nic\n\n");

    znak=getch();

        switch(znak){

            case 'a':
                {
                    system("cls");
                    printf("Autorem jestem ja. Czyli Mikolaj. \n\n");
                    printf("Jesli chcesz wrocic do glownego menu:\n");
                    printf("    * wcisnij 'f'\n");
                    znak=getch();
                    while(znak!='f'){

                    }
                    system("cls");
                    break;
                }
            case 'b':
                {
                    system("cls");
                    system("COLOR 79");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tczerwony");
                    Sleep(2000);
                    system("cls");

                    system("cls");
                    system("COLOR 71");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tzielony");
                    Sleep(2000);
                    system("cls");

                    system("cls");
                    system("COLOR 76");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tniebieski");
                    Sleep(2000);
                    system("cls");
                    break;


                }

            case 'c':
                {

                    system("cls");
                    system("COLOR 74");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tczerwony");
                    Sleep(2000);
                    system("cls");

                    system("cls");
                    system("COLOR 72");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tzielony");
                    Sleep(2000);
                    system("cls");

                    system("cls");
                    system("COLOR 71");
                    printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tniebieski");
                    Sleep(2000);
                    system("cls");

                    break;

                }

            case 'd':
                {
                    while(znak!='y'){
                        system("cls");
                        system("COLOR 02");
                        printf("");
                        Sleep(20);
                        system("COLOR 20");
                        printf("");
                        Sleep(20);
                        //znak=getch();
                    }
                    break;
                }

            default:
                {
                    printf("Wybrales opcje, ktorej nie ma w naszym menu.\n");
                    printf("Wybierz prosze ponownie: a, b, c, d, lub e.\n");

                }
        }



    }
    return 0;
}
