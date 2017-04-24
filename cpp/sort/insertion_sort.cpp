#include <ctime>
#include <cstdlib>
#include <iostream>
#include <cstring>

using namespace std;



int main()
{

    int tablica[6], temp;

    srand(time(NULL));

    cout << endl << "Before sorting" << endl;
    for (int j = 0; j < 6; j++)
    {
        int a = rand() % 9 + 1;
        tablica[j] = a;
        cout << a << " ";
    }
    cout << endl << endl;

    int j = 1;

    for ( int i = 0; i < 6; i++)
    {
        for (int j = i; j < 6; j++)
        {
			cout << "Is " << tablica[i] << " > " << tablica[j] << " ? ";
            if ( tablica[i] > tablica[j] )
            {
                cout << "YES!" << endl << endl << "Indeed, " << tablica[i] << " > " << tablica[j] << endl;
                cout << "Thus we insert " << tablica[j] << " where it belongs." << endl;
                cout << "How does our array look like now?" << endl;
                temp = tablica[j];

                for (int k = j-i; k > 0; k--)
                {
                    tablica[i+k] = tablica[i+k-1];
                }
                tablica[i] = temp;

                for(int l = 0; l < 6 ; l++)
                {
                    cout << tablica[l]<< " ";
                }
                cout << endl << endl;

                i=-1;
                break;
            }
            else
            {
                cout << "..... No." << endl;
            }
        }

    }
    cout << endl << "After sorting" << endl;
    for(int l = 0; l < 6 ; l++)
    {
        cout << tablica[l]<< " ";
    }
    cout << endl;
}

