#include <iostream>


using namespace std;

    int labyrinth[][10] = { {1,0,1,1,1,1,1,1,1,1},
    					    {1,0,0,0,0,0,0,0,0,1},
    					    {1,1,1,1,1,1,1,1,0,1},
    					    {1,0,0,0,0,0,0,0,0,1},
    					    {1,0,1,1,1,1,1,1,0,1},
    					    {1,0,1,0,0,0,0,1,0,1},
    					    {1,0,1,0,1,0,1,0,0,1},
    					    {1,0,1,0,1,0,1,0,1,1},
    					    {1,0,1,0,1,0,0,0,0,1},
    					    {1,1,1,0,1,1,1,1,1,1}, };

    int discovery[][10] = { {0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0},
    						{0,0,0,0,0,0,0,0,0,0}, };

    int width = 10, height = 10;
    int start_y = 5, start_x = 0;



void labyrinth_print(){

	 for (int i = 0; i < height; ++i)
	    {
	        for (int j = 0; j < width; ++j)
	        {
	            std::cout << labyrinth[i][j] << ' ';
	        }
	        std::cout << std::endl;
	    }
	 std::cout << std::endl;
    }

void discovery_print(){

	 for (int i = 0; i < height; ++i)
	    {
	        for (int j = 0; j < width; ++j)
	        {
	            std::cout << discovery[i][j] << ' ';
	        }
	        std::cout << std::endl;
	    }
    }

//int size_of_a_row(){
//
//}

int main()
//int main(void)
{
	std::cout << sizeof(discovery[0]);

    labyrinth_print();

    discovery_print();

    cout << endl;
	cout << endl;

	if(start_y == 0 || start_y == height-1){
		discovery[start_y][start_x - 1] = 1;
		discovery[start_y][start_x + 1] = 1;
	}

	if(start_x == 0 || start_x == width-1){
		discovery[start_x][start_y - 1] = 1;
		discovery[start_x][start_y + 1] = 1;
		}
//    discovery[start_y][start_x-1] = 1;


    discovery_print();

}


