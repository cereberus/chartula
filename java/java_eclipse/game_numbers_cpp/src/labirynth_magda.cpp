/* rand example: guess the number */
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
	int x = 0, y = 0; //pozycja gracza

	for (int k = 0; k < 20; k++) { //przechodzenie przez labirynt
		if ((x == 7) && (y == 3)) {
			cout << " wyszedłeś z labiryntu ";

			for (int i = 0; i < 8; i++) { //wczytywanie labiryntu z pliku
				for (int j = 0; j < 8; j++) {
					cout << lab[i][j] << " ";
					if (lab[i][j] == 8)
						lab[i][j] = 0;
				}
				cout << endl;
			}
			exit(0);
		}
		lab[x][y] = 4; // oznaczenie chodzącego pionka
		if ((x < maxx) && (lab[x + 1][y] == 0)) {
			x++;
		} else if ((y < maxx) && (lab[x][y + 1] == 0)) {
			y++;
		} else if ((x > 0) && (lab[x - 1][y] == 0)) {
			x--;
		} else if ((y > 0) && (lab[x][y - 1] == 0)) {
			y--;
		} else {

			if ((x < maxx) && (lab[x + 1][y] == 4)) {
				x++;
			} else if ((y < maxx) && (lab[x][y + 1] == 4)) {
				y++;
			} else if ((x > 0) && (lab[x - 1][y] == 4)) {
				x--;
			} else if ((y > 0) && (lab[x][y - 1] == 4)) {
				y--;
			}


			}
		for (int i = 0; i < 8; i++) { //wczytywanie labiryntu z pliku
						for (int j = 0; j < 8; j++) {
							cout << lab[i][j] << " ";
							if (lab[i][j] == 8)
								lab[i][j] = 0;
						}
						cout << endl;

		}
		cout << "x=" << x << " " << "y=" << y << endl;
	}
}
