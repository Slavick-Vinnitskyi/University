#include "pch.h"
#include "mpi.h"
#include <iostream>
#include <ctime>

#include "Function1.h"
#include "Function2.h"
#include "Function3.h"


void main(int argc, char* argv[])
{
	int rank;
	unsigned int start = 0;
	Function1 function1(5);
	Function2 function2(5);
	Function3 function3(5);

	MPI_Init(&argc, &argv);

	MPI_Comm_rank(MPI_COMM_WORLD, &rank);

	if (rank == 0) {
		function1.StartFunction(start);
		
	}
	else if (rank == 1) {
		function2.StartFunction(start);
	}
	else if (rank == 2) {

		function3.StartFunction(start);
	}

	std::cout << (float)(clock() - start) / 1000 << std::endl;

	MPI_Finalize();
}