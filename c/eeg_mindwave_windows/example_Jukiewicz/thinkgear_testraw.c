#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>
#include "thinkgear.h"

/**
 * Prompts and waits for the user to press ENTER.
 */
void
wait() {
    printf( "\n" );
    printf( "Nacisnij dowolny przycisk...\n" );
    fflush( stdout );
    getc( stdin );
}

/**
 * Program which prints ThinkGear Raw Wave Values to stdout.
 */
int
main( void ) {
	FILE *fp;
    char *comPortName  = NULL;
    int   connectionId = 0;
    int   packetsRead  = 0;
    int   errCode      = 0;
	int   ii           = 0;
	int   czas_trwania = 0;
	int   nrp		   = 0;

    printf( "Zaladowano plik DLL\n");

    connectionId = TG_GetNewConnectionId();

	printf( "Podaj numer portu COM urzadzenia:");
	scanf_s("%d",&nrp);
	 
	switch(nrp){
		case 3: comPortName = "\\\\.\\COM3";
				break;
		case 4: comPortName = "\\\\.\\COM4";
				break;
		case 5: comPortName = "\\\\.\\COM5";
				break;
		case 6: comPortName = "\\\\.\\COM6";
				break;
		case 7: comPortName = "\\\\.\\COM7";
				break;
		case 8: comPortName = "\\\\.\\COM8";
				break;
		case 9: comPortName = "\\\\.\\COM9";
				break;
		case 10: comPortName = "\\\\.\\COM10";
				break;
		case 11: comPortName = "\\\\.\\COM11";
				break;
		case 12: comPortName = "\\\\.\\COM12";
				break;
	}

    errCode = TG_Connect( connectionId, comPortName, TG_BAUD_57600, TG_STREAM_PACKETS );
    if( errCode < 0 ) {
        fprintf( stderr, "Blad: Nie podlaczono urzadzenia lub wybrano zly port COM\n", errCode );
        wait();
        exit( EXIT_FAILURE );
    }
	printf( "Wybrano port numer: %d. Polaczono z urzadzeniem\n",nrp);
	printf( "Podaj czas trwania zapisu sygnalu EEG:");
	scanf_s("%d",&czas_trwania);
	//czas_trwania=getc(stdin);
	remove("wynik.txt");
	fp=fopen("wynik.txt","w");
	printf( "Zapis bedzie trwal: %d\n",czas_trwania);
	printf( "Pliki zapisu otwarte\n");
	wait();
    while( ii < czas_trwania*512+1 ) {

            packetsRead = TG_ReadPackets( connectionId, 1 );

            if( packetsRead == 1 ) {

                if( TG_GetValueStatus(connectionId, TG_DATA_RAW) != 0 ) {
                    fprintf( stdout, "raw: %d, att: %d, med: %d \n", (int)TG_GetValue(connectionId, TG_DATA_RAW), (int)TG_GetValue(connectionId,TG_DATA_ATTENTION), (int)TG_GetValue(connectionId,TG_DATA_MEDITATION));
                    fflush( stdout );
					ii=ii+1;
					fprintf (fp, "%d, %d, %d\n", (int)TG_GetValue(connectionId, TG_DATA_RAW), (int)TG_GetValue(connectionId,TG_DATA_ATTENTION), (int)TG_GetValue(connectionId,TG_DATA_MEDITATION));
                } 
            }

    } 
    TG_FreeConnection( connectionId );

    wait();
    return( EXIT_SUCCESS );
	fclose (fp);
}
