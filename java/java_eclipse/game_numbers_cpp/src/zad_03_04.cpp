/* rand example: guess the number */
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <iostream>
#include <fstream>

#include <iostream>

using namespace std;

int cos()
//int main()
{
  int comp_random, user_number; /* 2 zmienne: 1 przechowujaca wylosowana przez kom liczbe, druga to ta ktora jest naszym strzalem */
  int round_nr = 0; /* round_nr to numer rundy */
		cout << endl;
		cout << endl;
		cout << "-- -- --";    	
		cout << endl;
        cout << "Witajcie w grze w szukanie wylosowanej przez komputer liczby. Komputer losuje liczbę całkowitą z przedziału (0,100), a użytkownik ma ją zgadnąć; na każdym etapie program wypisuje numer rundy oraz jeden z komunikatów: za mało, za dużo, zgadłeś.";
        cout << endl;
        cout << endl;


  /* initialize random seed: */
  srand (time(NULL));

  /* generate secret number between 1 and 10: */
  comp_random = rand() % 101;

  do {
    cout << endl;
    round_nr ++;
    cout << "Runda nr: "<< round_nr;
    cout << endl;
    printf ("Zgadnij liczbe od 0 do 100: ");
    scanf ("%d",&user_number);
    if (comp_random<user_number) puts ("Liczba, ktorej szukasz jest mniejsza");
    else if (comp_random>user_number) puts ("Liczba, ktorej szukasz jest wieksza");
  } while (comp_random!=user_number);

  puts ("Brawo! Zgadles!");
  cout << "-- -- --"; 
  cout << endl;
  cout << endl;
  cout << endl;
  cout << endl;
  return 0;
}
