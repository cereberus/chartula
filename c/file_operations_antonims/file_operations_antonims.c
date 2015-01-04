#include <stdio.h>
#include <stdlib.h>

int main()
{
    char znak;
    FILE *plik;
    char tekst[11][11]={0};
    char tekscik[10][11]={0};
    char tekscioszek[10][11]={0};

    int i;
    int j;

    while(znak!='q'){
        system("COLOR 02");
        printf("Co chcesz zrobic?\n\n");
        printf("(a) Info o autorze.\n");
        printf("(b) Wpisywanie wyrazow.\n");;
        printf("(c) Eksperyment.\n");;
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

                        if((plik=fopen("pierwszy.txt","w"))!=NULL){
                                for(i=0;i<10;i++){
                                    printf("\n\n\n\n\n\n\n\n\n\t\t\t\tWpisz wyrazy: ");
                                    scanf("%s",&tekscik);
                                    fprintf(plik, "%s\n",tekscik);
                                    system("cls");
                                }
                        }

                        fclose(plik);

                        system("cls");
                        break;
                    }

                case 'c':
                    {
                        system("cls");

                        if((plik=fopen("antonimy.txt","w"))!=NULL){
                            //printf("\n\n\n\n\n\n\n\n\n\t\t\t\tWpisz wyrazy: ");
                        }

                        fclose(plik);

                        if((plik=fopen("pierwszy.txt","r"))!=NULL){
                             for(i=0;i<10;i++){
                                    for(j=0;j<11;j++){
                                        tekst[i][j]=getc(plik);
                                            if(tekst[i][j] == '\n'){
                                                j=11;
                                            }
                                    }
                            }
                        }
                        fclose(plik);


                        for(i=0;i<10;i++){

                            system("cls");

                            if((plik=fopen("pierwszy.txt","r"))!=NULL){
                                printf("\n\n\n\n\n\n\n\n\n\t\t\t\t");
                               // for(i=0;i<11;i++){
                                    for(j=0;j<11;j++){
                                        printf("%c",tekst[i][j]);
                                            if(tekst[i][j] == '\n'){
                                                j=11;
                                            }
                                    }
                                //}
                            }
                            fclose(plik);

                            if((plik=fopen("antonimy.txt","a"))!=NULL){
                                    //for(i=0;i<10;i++){
                                        printf("\n\t\t\t\tWpisz antonim: ");
                                        scanf("%s",&tekscioszek);
                                        fprintf(plik, "%s\n",tekscioszek);
                                  //  }
                            }

                            fclose(plik);




                        }
                            system("cls");
                            printf("\n\n");
                            printf("Wpisywanie antonimow zakonczone.\n");
                            printf("Jesli chcesz wrocic do glownego menu:\n");
                            printf("    * wcisnij 'f'\n");
                            znak=getch();
                            while(znak!='f'){

                        }

                        system("cls");
                        break;
                    }




                default:
                    {
                        system("cls");
                        printf("Wybrales opcje, ktorej nie ma w naszym menu.\n");
                        printf("Wybierz prosze ponownie: a, b, c lub q.\n");

                    }
            }
        }
}
