#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;

const int maxx = 8; //definiujemy maksimum jako stałą
int main() {
	int lab[8][8];

	for (int i = 0; i < 8; i++) { //wczytywanie labiryntu z pliku
		for (int j = 0; j < 8; j++) {

			cin >> lab[i][j];
			cout << lab[i][j] << " ";
		}
		cout << endl;
	}
	int x = 1, y = 1; //pozycja generatora
	for (int k = 0; k < 20; k++) {
		for (int i = 0; i < 8; i++) { //wczytywanie labiryntu z pliku
			for (int j = 0; j < 8; j++) {
				cout << lab[i][j] << " ";
				if (lab[i][j] == 8)
					lab[i][j] = 0;
			}
		}
		lab[x][y]=0;// to tworzy labirynt
		if ((lab[x][y]* lab[x+1][y]* lab[x][y+1]* lab[x][y-1])== 1){
			lab[x][y] = 0;x++;
		}else if (lab[x][y]* lab[x-1][y]* lab[x][y-1]* lab[x][y+1]== 1){
			 lab[x][y] = 0;x--;
		}else if (lab[x][y]* lab[x-1][y]* lab[x][y-1]* lab[x][y+1]== 1){
			 lab[x][y] = 0;y--;
		}else if (lab[x][y]* lab[x+1][y]*lab[x][y+1]* lab[x][y-1]== 1){
			 lab[x][y] = 0;y++;
		}
		}

	for (int i = 0; i < 8; i++) { //wczytywanie labiryntu z pliku
		for (int j = 0; j < 8; j++) {


			cout << lab[i][j] << " ";
		}
		cout << endl;
	}

	}
