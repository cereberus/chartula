#include <stdio.h>
#include "floatfann.h"

int main()
{
	fann_type *calc_out;
	fann_type input[512];

	struct fann *ann = fann_create_from_file("eeg_magda_float.net");

    input[512] = -2306;  
	
    calc_out = fann_run(ann, input);

	printf("is it blink or norma %f\n", calc_out[0]);

	fann_destroy(ann);
	return 0;
}
