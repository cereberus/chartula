/*
Fast Artificial Neural Network Library (fann)
Copyright (C) 2003-2012 Steffen Nissen (sn@leenissen.dk)

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

#include <stdio.h>
#include "floatfann.h"

int main()
{
	fann_type *calc_out;
	fann_type input[4];

	struct fann *ann = fann_create_from_file("b_and_w_float.net");

	input[0] = 220;
	input[1] = 201;
	input[2] = 200;
	input[3] = 230;
	calc_out = fann_run(ann, input);

	printf("is it black or white (%f,%f,%f,%f) -> %f %f\n", input[0], input[1], input[2], input[3], calc_out[0], calc_out[1]);

	fann_destroy(ann);
	return 0;
}
