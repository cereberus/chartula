/* rand example: guess the number */
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <iostream>
#include <fstream>

using namespace std;

int main ()
{
    int comp_random; /* przechowuje wylosowana przez kom liczbe */
    char user_clue; /* jest nasza podpowiedzia dla komputera, trzecia to typowana przez komputer liczba */
    int round_nr = 0; /* round_nr to numer rundy */
    int comp_guess = 50;

		cout << endl;
		cout << endl;
		cout << "-- -- --";    	
		cout << endl;
        cout << "Witajcie w grze w szukanie wylosowanej liczby. Losuje się liczbe całkowita z przedziału (0,100), a komputer ma ja zgadnac; na każdym etapie program wypisuje numer rundy oraz liczbe szukana (aby przypomniec ja uzytkownikowi). W każdej rundzie uzytkownik podaje, czy liczba proponowana przez komputer jest za mała, za duża, czy komputer zgadł właściwą.";
        cout << endl;
        cout << endl;


  /* initialize random seed: */
  srand (time(NULL));

  /* generate secret number between 1 and 10: */
  comp_random = rand() % 101;

  do {
    cout << endl;
    round_nr ++;
    cout << "Runda nr: "<< round_nr << endl;
    cout << "Liczba, ktorej szuka komputer to: "<< comp_random << endl;
    if (round_nr>1) 
        {
        if (user_clue=="za mala") copm_guess += copm_guess/2+0.5;        
        if (user_clue=="za duza") copm_guess -= copm_guess/2+0.5;
        cout <<"Liczba, ktora typuje komputer to: "<< comp_guess << endl << endl;
        }

    printf ("Podpowiedz komputerowi: za mala, za duza lub zgadles: ");
    scanf ("%d",&user_clue);
    if (user_clue!="za mala" || user_clue!="za duza" || user_clue!="zgadles") puts ("Mozesz podpowiedziec tylko i wylacznie 3 rzeczy: \" za mala\",\" za duza\",\" zgadles\"");
    
  } while (user_clue!="zgadles");

  puts ("Brawo! Zgadles!");
  cout << "-- -- --"; 
  cout << endl;
  cout << endl;
  cout << endl;
  cout << endl;
  return 0;
}
